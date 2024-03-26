package leetcode.Two.reverseKGroup;

import leetcode.Util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2024/3/26 10:39 AM
 * @Version: 1.initial version; 2024/3/26 10:39 AM
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        List<ListNode> segList = new ArrayList<>();
        int step = 0;
        ListNode node = head;
        ListNode headNode = head;
        while (node != null) {
            node = node.next;
            step++;
            if (step == k) {
                segList.add(headNode);
                headNode = node.next;
                node.next = null;
            }
        }
        return null;
    }


    // 1 -> 2 -> 3 -> 4
    public ListNode reverse(ListNode node, int i, int k) {
        int index = 0;
        while (index < i) {
            node = node.next;
            i++;
        }
        ListNode temp = null;
        ListNode preNode = node;
        node = node.next;
        int reverseTimes = 0;
        while (node != null && reverseTimes < k) {
            temp = node.next;  // temp -> 3
            preNode.next = null; // 1 -> null;
            node.next = preNode; // 2 -> 1;
            preNode = node;
            node = temp;   // node -> 3;
            reverseTimes++;
        }
        return node;
    }
}
