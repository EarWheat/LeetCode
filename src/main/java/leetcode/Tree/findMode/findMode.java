package leetcode.Tree.findMode;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-24 14:20
 * @desc
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class findMode {
    private static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public static int[] findMode(TreeNode root) {
        countTree(root);
        List<Integer> result = new ArrayList<>();
        int maxTimes = 1;
        for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            if(entry.getValue() > maxTimes){
                if(result.size() == 0){
                    maxTimes = Math.max(maxTimes,entry.getValue());
                    result.add(entry.getKey());
                } else {
                    result.clear();
                    maxTimes = Math.max(maxTimes,entry.getValue());
                    result.add(entry.getKey());
                }
            }
            else if(entry.getValue() == maxTimes){
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static void countTree(TreeNode root){
        if(root == null){
            return;
        }
        if(hashMap.containsKey(root.val)){
            int temp = hashMap.get(root.val) + 1;
            hashMap.put(root.val,temp);
        } else {
            hashMap.put(root.val,1);
        }
        if(root.left != null){
            countTree(root.left);
        }
        if(root.right != null){
            countTree(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightLeft = new TreeNode(2);
        TreeNode rightRight = new TreeNode(3);
        TreeNode rightRightRight = new TreeNode(3);
        treeNode.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        rightRight.right = rightRightRight;
        System.out.println(findMode(treeNode).toString());
    }
}
