package Interview.treeToDoublyList;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ：liuzhaolu
 * @description：剑指 Offer 36. 二叉搜索树与双向链表
 * @prd : https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @date ：2022/4/21 3:17 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/21 3:17 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> nodes = orderNode(root);
        if (nodes.size() == 1) {
            Node node = nodes.poll();
            node.left = node;
            node.right = node;
            return node;
        }
        if (nodes.size() == 2) {
            Node node1 = nodes.poll();
            Node node2 = nodes.poll();
            node1.right = node2;
            node2.left = node1;
            node1.left = node2;
            node2.right = node1;
            return node1;
        }
        Node node = nodes.poll();
        Node head = node;
        while (!nodes.isEmpty()) {
            Node next = nodes.poll();
            node.right = next;
            next.left = node;
            node = next;
        }
        head.left = node;
        node.right = head;
        return head;
    }

    // 返回尾结点
    public Queue<Node> orderNode(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> result = new LinkedBlockingQueue<>();
        if (root.left != null) {
            result.addAll(orderNode(root.left));
        }
        result.add(root);
        if (root.right != null) {
            result.addAll(orderNode(root.right));
        }
        return result;
    }

    public Node headNode(Node root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            Node temp = headNode(root.right);
            root.right = temp;
            temp.left = root;
        }
        return root;
    }


    public String preOrder(Node root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root.left != null) {
            stringBuilder.append(preOrder(root.left));
        }
        stringBuilder.append(root.val);
        if (root.right != null) {
            stringBuilder.append(preOrder(root.right));
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node4.right = node5;
        node4.left = node2;
        node2.left = node1;
        node2.right = node3;
        Solution solution = new Solution();
//        System.out.println(solution.preOrder(node4));
        System.out.println(solution.treeToDoublyList(node1));
    }
}
