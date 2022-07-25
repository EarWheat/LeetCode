package leetcode.Nine.CBTInserter;

import leetcode.Util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/25 6:26 PM
 * @Version: 1.initial version; 2022/7/25 6:26 PM
 */
public class CBTInserter {

    Queue<TreeNode> candidate;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.candidate = new ArrayDeque<TreeNode>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (!(node.left != null && node.right != null)) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }
}
