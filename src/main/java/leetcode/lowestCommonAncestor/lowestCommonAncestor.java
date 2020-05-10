package main.java.leetcode.lowestCommonAncestor;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-10 15:05
 * @desc:给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
* 思路：按照中序遍历，再从根往下遍历，如果目标节点分别在左右两侧，则改节点是最近公共祖先，如果在同一侧，则继续遍历。
 */
public class lowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        TreeNode leftL = new TreeNode(6);
        TreeNode leftR = new TreeNode(2);
        TreeNode rightL = new TreeNode(0);
        TreeNode rightR = new TreeNode(8);
        TreeNode leftRL = new TreeNode(7);
        TreeNode leftRR = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.left = leftL;
        left.right = leftR;
        right.left = rightL;
        right.right = rightR;
        leftR.left = leftRL;
        leftR.right = leftRR;
        System.out.println(zhongXu(root));
        System.out.println(houXu(root));
        System.out.println(lowestCommonAncestor(root,left,right).val);
        System.out.println(lowestCommonAncestor(root,left,leftRR).val);
        System.out.println(lowestCommonAncestor(root,right,rightR).val);
        System.out.println(lowestCommonAncestor(root,rightL,rightR).val);
        System.out.println(lowestCommonAncestor(root,leftRL,rightL).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 先判断根节点是否等于p或q
        if(root == p){
            String zhongxu = zhongXu(root);
            if(zhongxu.contains(String.valueOf(q.val))){
                return p;
            }
        }
        if(root == q){
            String zhongxu = zhongXu(root);
            if(zhongxu.contains(String.valueOf(p.val))){
                return q;
            }
        }
        // root即不等于p也不等于q
        // 先中序遍历
        String zhongxu = zhongXu(root);
        // 根据根节点分隔两侧
        String[] temp = zhongxu.split(String.valueOf(root.val));
        // 只有左子树或右子树，且root不等于p,q
        if(temp.length == 1){
            if(root.left != null){
                return lowestCommonAncestor(root.left,p,q);
            } else {
                return lowestCommonAncestor(root.right,p,q);
            }
        }
        String left = temp[0]; // 左子树节点
        String right = temp[1]; // 右子树节点
        // 如果p,q在左子树
        if(left.contains(String.valueOf(p.val)) && left.contains(String.valueOf(q.val))){
            return lowestCommonAncestor(root.left,p,q);
        }
        // 如果p,q在右子树
        if(right.contains(String.valueOf(p.val)) && right.contains(String.valueOf(q.val))){
            return lowestCommonAncestor(root.right,p,q);
        }
        // 如果p,q分别在左右子树，则root是最近公共祖先
        return root;
    }

    // 中序遍历
    public static String zhongXu(TreeNode root){
        String result = "";
        if(root.left != null){
            result += zhongXu(root.left);
        }
        result += root.val;
        if(root.right != null){
            result += zhongXu(root.right);
        }
        return result;
    }

    // 后序遍历
    public static String houXu(TreeNode root){
        String result = "";
        if(root.left != null){
            result += houXu(root.left);
        }        if(root.right != null){
            result += houXu(root.right);
        }
        result += root.val;
        return result;
    }

    // 答案
    // 递归左右子树，左不为空说明节点在左侧，右不为空说明节点在右侧。
    public static TreeNode answer(TreeNode root, TreeNode p, TreeNode q){
        // LCA 问题
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
