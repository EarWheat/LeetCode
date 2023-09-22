package Interview;

import leetcode.Util.ListNode;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/9/21 9:51 AM
 * @Version: 1.initial version; 2023/9/21 9:51 AM
 */
public class Solution {
    public ListNode rotateLinkedList (ListNode head, int k) {
        int index = 0;
        int length = 0;
        ListNode preNode = head;
        ListNode nextNode = head;
        while (nextNode != null) {
            // 先走k个位置
            nextNode = nextNode.next;
            if (index == k) {
                break;
            }
            index++;
            length++;
        }
        // 缩短K
        if (nextNode == null) {
            k = k % length;
        }
        return getHeadList(head, k);

    }

    public ListNode getHeadList(ListNode head, int k) {
        ListNode preNode = head;
        ListNode node = head;
        for (int i = 0; i< k; i ++) {
            node = node.next;
        }
        while (node.next != null) {
            preNode = preNode.next;
            node = node.next;
        }
        node.next = head;
        ListNode result = preNode.next;
        preNode.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        ListNode listNode = solution.rotateLinkedList(node1, 7);
        System.out.println(listNode);

    }
}
