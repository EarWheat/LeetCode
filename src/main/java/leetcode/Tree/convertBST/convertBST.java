package leetcode.Tree.convertBST;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-21 09:37
 * @desc 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class convertBST {
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    /**
     * 因为是二叉搜索树,所以最右节点一定是最大值，从最右子节点开始递归
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }
        if(root.right != null){
            root.right = convertBST(root.right);
            root.val = root.val + rightMaxVal(root.right);
        }
        if(root.left != null){
            root.left = convertBST(root.left);
            valGreater(root.left, root.val);
        }
        return root;
    }

    private static void valGreater(TreeNode root, Integer val){
        if(root == null){
            return;
        }
        root.val += val;
        if(root.left != null){
            valGreater(root.left, val);
        }
        if(root.right != null){
            valGreater(root.right, val);
        }
    }

    private static Integer rightMaxVal(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        if(root.left != null){
            return rightMaxVal(root.left);
        }
        return root.val;
    }

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(5);
//        TreeNode left = new TreeNode(2);
//        TreeNode right = new TreeNode(13);
//        root.left = left;
//        root.right = right;
//        TreeNode temp = convertBST(root);
//        System.out.println(temp.val);
        /**
         *             2                        5                       2                  19
         *            / \                      / \                     / \                / \
         *           0  3                     6  3                    0  5               19 13
         *          / \                      / \                        / \                 / \
         *        -4  1                     2  6                       4  8                17 8
         */
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(5);
        TreeNode leftL = new TreeNode(-4);
        TreeNode leftR = new TreeNode(1);
        TreeNode rightL = new TreeNode(4);
        TreeNode rightR = new TreeNode(8);
        root.left = left;
        root.right = right;
//        left.left = leftL;
//        left.right = leftR;
        right.left = rightL;
        right.right = rightR;
        TreeNode temp = convertBST(root);
        System.out.println(temp.val);
    }

}
