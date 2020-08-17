package leetcode.Tree.isBalanced;

import UtilClass.Tree;

import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-17 16:16
 * @desc:给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。

 */
public class isBalanced {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return false;
        }
//        int left = root.left != null ? TreeDepth(root.left) : 0;
//        int right = root.right != null ? TreeDepth(root.right) : 0;
        return Math.abs((root.left != null ? TreeDepth(root.left) : 0) - (root.right != null ? TreeDepth(root.right) : 0)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//        return Math.abs(left - right) <= 1;
    }

    // 求树最大的深度
    private static int TreeDepth(TreeNode root){
        return Math.max(root.left != null ? TreeDepth(root.left) + 1 : 1 , root.right != null ? TreeDepth(root.right) + 1 : 1);
//        int deepLeft = 1;
//        int deepRight = 1;
//        if(root.left != null){
//            deepLeft = TreeDepth(root.left) + 1;
//        }
//        if(root.right != null){
//            deepRight = TreeDepth(root.right) + 1;
//        }
//        return Math.max(deepLeft,deepRight);
    }



    /**
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        System.out.println(isBalanced(root));

        /**
         *        1
         *       / \
         *      2   2
         *     / \
         *    3   3
         *   / \
         *  4   4
         */
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        TreeNode left1Left = new TreeNode(3);
        TreeNode left1Right = new TreeNode(3);
        TreeNode left1LeftLeft = new TreeNode(4);
        TreeNode left1LeftRight = new TreeNode(4);
        root1.left = left1;
        root1.right = right1;
        left1.left = left1Left;
        left1.right = left1Right;
        left1Left.left = left1LeftLeft;
        left1Left.right = left1LeftRight;
        System.out.println(isBalanced(root1));


        TreeNode root2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(2);
        TreeNode right2Right = new TreeNode(3);
        root2.right = right2;
        right2.right = right2Right;
        System.out.println(isBalanced(root2));
    }
}
