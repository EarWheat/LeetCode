package leetcode.Tree.maxDepth;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-28 10:12
 * @desc:
 * 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。

 */
public class maxDepth {
    public static int maxDepth(TreeNode root) {
        int deep = 0;
        int leftDeep = 0;
        int rightDeep = 0;
        if(root != null){
            deep++;
        } else {
            return 0;
        }
        if(root.left != null){
            leftDeep = maxDepth(root.left);
        }
        if(root.right != null){
            rightDeep = maxDepth(root.right);
        }
        return deep + Math.max(leftDeep, rightDeep);
    }

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
        System.out.println(maxDepth(root));

    }
}
