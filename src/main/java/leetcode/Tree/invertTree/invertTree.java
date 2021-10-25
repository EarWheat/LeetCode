package leetcode.Tree.invertTree;

import UtilClass.Tree;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-16 19:15
 * @desc
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class invertTree {
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        if(root.left != null || root.right != null){
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        TreeNode leftL = new TreeNode(1);
        TreeNode leftR = new TreeNode(3);
        TreeNode rightL = new TreeNode(6);
        TreeNode rightR = new TreeNode(9);
        root.left = left;
        root.right = right;
        left.left = leftL;
        left.right = leftR;
        right.left = rightL;
        right.right = rightR;
        TreeNode result = invertTree(root);
        System.out.println(result.val);
    }
}
