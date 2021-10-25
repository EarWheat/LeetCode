package leetcode.Tree.insertIntoBST;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-30 09:54
 * @desc 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 *  
 *
 * 例如, 
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class insertIntoBST {
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        // 值比根结点值大，需要插入右子树
        if(val > root.val){
            // 右子树为空
            if(root.right == null){
                TreeNode right = new TreeNode(val);
                root.right = right;
                return root;
            } else {
                // 右子树非空
                root.right = insertIntoBST(root.right,val);
                return root;
            }
        }
        // 题目中说过值不与树中的值相等，所以没有等于的情况
        if(val < root.val){
            // 同右子树逻辑
            if(root.left == null){
                TreeNode left = new TreeNode(val);
                root.left = left;
                return root;
            } else {
                root.left = insertIntoBST(root.left,val);
                return root;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;
        TreeNode temp = insertIntoBST(node4,5);
        System.out.println(temp.val);
    }
}
