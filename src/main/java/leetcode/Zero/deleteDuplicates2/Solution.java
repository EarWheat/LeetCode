package leetcode.Zero.deleteDuplicates2;

import leetcode.Util.ListNode;

/**
 * @Desc: 82. 删除排序链表中的重复元素 II
 * @Author: 泽露
 * @Date: 2024/1/15 4:09 PM
 * @Version: 1.initial version; 2024/1/15 4:09 PM
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
