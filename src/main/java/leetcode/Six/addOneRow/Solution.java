package leetcode.Six.addOneRow;

import leetcode.Util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/5 5:25 PM
 * @Version: 1.initial version; 2022/8/5 5:25 PM
 */
class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int deep = 1;
        while (!queue.isEmpty()) {
            if (deep == depth - 1) {
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    TreeNode newLeft = new TreeNode(val);
                    TreeNode newRight = new TreeNode(val);
                    node.left = newLeft;
                    node.right = newRight;
                    newLeft.left = left;
                    newRight.right = right;
                }
                break;
            }
            Queue<TreeNode> newQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    newQueue.add(node.left);
                }
                if (node.right != null) {
                    newQueue.add(node.right);
                }
            }
            deep++;
            queue = newQueue;
        }
        return root;
    }
}
