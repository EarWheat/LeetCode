package leetcode.Tree.mergeTrees;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-23 09:35
 * @desc
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class mergeTrees {
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }
        if(t1 == null && t2 != null){
            return t2;
        }
        if(t1 != null && t2 == null){
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t1left = new TreeNode(3);
        TreeNode t1right = new TreeNode(2);
        TreeNode t1leftleft = new TreeNode(5);
        t1.left = t1left;
        t1.right = t1right;
        t1left.left = t1leftleft;
        TreeNode t2 = new TreeNode(2);
        TreeNode t2left = new TreeNode(1);
        TreeNode t2right = new TreeNode(3);
        TreeNode t2leftright = new TreeNode(4);
        TreeNode t2rightright = new TreeNode(7);
        t2.left = t2left;
        t2.right = t2right;
        t2left.right = t2leftright;
        t2right.right = t2rightright;
        TreeNode root = mergeTrees(t1,t2);
        System.out.println(root.val);
    }
}
