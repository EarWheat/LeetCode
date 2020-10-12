package leetcode.Tree.getMinimumDifference;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-12 16:27
 * @desc 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class getMinimumDifference {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if(root == null){
            return 0;
        }
        if(root.left != null){
            min = Math.min(min,Math.abs(root.val - getLeftMaxNode(root.left).val));
            min = Math.min(min, getMinimumDifference(root.left));
        }
        if(root.right != null){
            min = Math.min(min,Math.abs(root.val - getRightMinNode(root.right).val));
            min = Math.min(min, getMinimumDifference(root.right));
        }
        return min;
    }

    // 获取左子树最大的节点
    public static TreeNode getLeftMaxNode(TreeNode root){
        if(root == null){
            return root;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        if(root.right != null){
            return getLeftMaxNode(root.right);
        } else {
            return root;
        }
    }

    // 获取右子树最小的节点
    public static TreeNode getRightMinNode(TreeNode root){
        if(root == null){
            return root;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        if(root.left != null){
            return getRightMinNode(root.left);
        } else {
            return root;
        }
    }

    /**
     *          236
     *         /  \
     *        104 701
     *         \   \
     *        227  911
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(236);
        TreeNode node2 = new TreeNode(104);
        TreeNode node3 = new TreeNode(701);
        TreeNode node4 = new TreeNode(227);
        TreeNode node5 = new TreeNode(911);
        TreeNode node6 = new TreeNode(700);
        node1.right = node3;
        node1.left = node2;
        node2.right = node4;
        node3.right = node5;
        node3.left = node6;
        System.out.println(getMinimumDifference(node1));
    }
}
