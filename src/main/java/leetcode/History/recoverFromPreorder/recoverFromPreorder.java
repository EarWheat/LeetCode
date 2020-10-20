package leetcode.History.recoverFromPreorder;

import java.util.ArrayList;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-18 11:07
 * @desc:
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。

在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。

如果节点只有一个子节点，那么保证该子节点为左子节点。

给出遍历输出 S，还原树并返回其根节点 root。

 

示例 1：



输入："1-2--3--4-5--6--7"
输出：[1,2,5,3,4,6,7]
示例 2：



输入："1-2--3---4-5--6---7"
输出：[1,2,5,3,null,6,null,4,null,7]
示例 3：



输入："1-401--349---90--88"
输出：[1,401,null,349,88,90]

*
* 思路：
// 遍历第一层，减去string
    // "1-401--349---90--88"      => "401-349--90-88"       =>     "349-9088"
    // String[0]   root     1
    // String[1]   left     401-349--90-88
    // String[2]   right    null
    *
    * 然后左子树递归401-349--90-88
    * String[0]    root     401
    * String[1]    left     349-90
    * String[2]    right    88
 */
public class recoverFromPreorder {

    public static TreeNode recoverFromPreorder(String S) {
        if(S.length() == 0){
            return null;
        }
        List<String> treeString = cutString(S);
        if(treeString.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(treeString.get(0)));
        if(treeString.size() >= 2) {
            root.left = recoverFromPreorder(treeString.get(1));
        }
        if(treeString.size() >= 3) {
            root.right = recoverFromPreorder(treeString.get(2));
        }
        return root;
    }

    // 遍历第一层，减去string
    // "1-401--349---90--88"      => "401-349--90-88"       =>     "349-9088"
    // String[0]   root     1
    // String[1]   left     401-349--90-88
    // String[2]   right    null
    private static List<String> cutString(String S){
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(S);
        int i;
        int j;
        // 根节点
        for(i = 1; i < stringBuilder.length() - 1; i++) {
            if (stringBuilder.charAt(i) == '-' && stringBuilder.charAt(i + 1) != '-' && stringBuilder.charAt(i - 1) != '-') {
                list.add(stringBuilder.substring(0,i));
                break;
            }
        }
        // 只有一个根节点
        if(i >= stringBuilder.length() - 1){
            list.add(stringBuilder.toString());
            return list;
        }
        // 子树
        for(j = i + 1; j < stringBuilder.length() - 1; j++){
            // 右子树
            if (stringBuilder.charAt(j) == '-' && stringBuilder.charAt(j + 1) != '-' && stringBuilder.charAt(j - 1) != '-') {
                // 左子树
                list.add(cut(stringBuilder.substring(i + 1,j)));
                // 右子树
                list.add(cut(stringBuilder.substring(j + 1, stringBuilder.length())));
                break;
            }
        }
        // 无右子树
        if(j >= stringBuilder.length() - 1){
            list.add(cut(stringBuilder.substring(i + 1, stringBuilder.length())));
        }
        return list;
    }

    public static String cut(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        for(int i = 1; i < stringBuilder.length() - 1; i++){
            if(stringBuilder.charAt(i) == '-' && stringBuilder.charAt(i - 1) == '-' && stringBuilder.charAt(i + 1) != '-'){
                stringBuilder.deleteCharAt(i);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        TreeNode treeNode = recoverFromPreorder("1-2--3---4-5--6---7");
        System.out.println(treeNode.val);
        System.out.println(treeNode.left);
    }
}
