package leetcode.Zero.recoverTree;

import leetcode.Util.TreeNode;

/**
 * @author ：liuzhaolu
 * @description：99. 恢复二叉搜索树
 * @prd :
 * @date ：2022/3/2 5:39 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/2 5:39 下午     liuzhaolu       firstVersion
 */
public class Solution {
    TreeNode t1, t2, pre;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    public void inorder(TreeNode root){
        if (root == null) return ;
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }

    public void swapTreeNode(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public static String midOrder(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (root.left != null) {
            stringBuilder.append(midOrder(root.left));
        }
        stringBuilder.append(root.val);
        if (root.right != null) {
            stringBuilder.append(midOrder(root.right));
        }
        return stringBuilder.toString();
    }
}
