package leetcode.Four.Codec;

import leetcode.Util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/11 2:46 PM
 * @Version: 1.initial version; 2022/5/11 2:46 PM
 */
public class Answer {
    // Encodes a tree to a single string.
    // 先序遍历
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(sb, root);
        return sb.length() == 0 ? "" : sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    // 因为是搜索二叉树，所以排序后即为中序遍历，然后跟进先序+中序还原
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        Queue<Integer> queue = Arrays.stream(data.split(","))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
        return construct(queue, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private void preOrder(StringBuilder sb, TreeNode node) {
        if (node != null) {
            sb.append(node.val).append(',');
            preOrder(sb, node.left);
            preOrder(sb, node.right);
        }
    }

    private TreeNode construct(Queue<Integer> queue, int max, int min) {
        if (queue.isEmpty() || queue.peek() > max || queue.peek() < min) {
            return null;
        }
        TreeNode node = new TreeNode(queue.poll());
        node.left = construct(queue, node.val, min);
        node.right = construct(queue, max, node.val);
        return node;
    }
}
