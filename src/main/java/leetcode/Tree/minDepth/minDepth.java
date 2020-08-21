package leetcode.Tree.minDepth;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-21 10:30
 * @desc:
 * 给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

 */
public class minDepth {
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right != null){
            return 1 + minDepth(root.right);
        }
        if(root.left != null && root.right == null){
            return 1 + minDepth(root.left);
        }
        int result = 1;
        int leftDepth = 0;
        int rightDepth = 0;
        if(root.left != null){
            leftDepth = minDepth(root.left);
        }
        if(root.right != null){
            rightDepth = minDepth(root.right);
        }
        return result + Math.min(leftDepth,rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
//        root.right = right;
//        right.left = rightLeft;
//        right.right = rightRight;
        System.out.println(minDepth(root));
    }
}
