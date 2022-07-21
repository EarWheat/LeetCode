package leetcode.Eight.pruneTree;

import leetcode.Util.TreeNode;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/21 5:52 PM
 * @Version: 1.initial version; 2022/7/21 5:52 PM
 */
public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return root;
        }
        cutTreeNode(root, root.left);
        cutTreeNode(root, root.right);
        if(root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }

    public void cutTreeNode(TreeNode parentNode, TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.val == 1) {
            // 递归剪左右树就好
            cutTreeNode(currentNode, currentNode.left);
            cutTreeNode(currentNode, currentNode.right);
        } else {
            // 先把左树剪了
            if (currentNode.left != null) {
                cutTreeNode(currentNode, currentNode.left);
            }
            // 再把右树剪了
            if (currentNode.right != null) {
                cutTreeNode(currentNode, currentNode.right);
            }
            // 都给剪没了
            if (currentNode.left == null && currentNode.right == null) {
                if (parentNode.left == currentNode) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            }
        }
    }
}
