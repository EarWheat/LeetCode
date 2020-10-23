package leetcode.zero.reverseBetween;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-23 19:20
 * @desc 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class reverseBetween {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        int reverseLength = m - n + 1;
        ListNode slow = head;
        ListNode fast = head;
        // 拉开需要反转链表的距离
        for(int i = 0;i < reverseLength;i++){
            fast = fast.next;
        }
        // 找到需要反转的前一个节点的位置
        for(int i = 0; i < m - 2; i++){
            slow = slow.next;
            fast = fast.next;
        }
        // 先记录fast的temp
        ListNode temp = fast.next;
        fast.next = null;
        ListNode reverseHead = slow.next;
        slow.next = reverseList(reverseHead);
        reverseHead.next = temp;
        return head;
    }

    private ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        //5->4->3->2
        ListNode temp = head.next;
        ListNode newHead = reverseList(head.next);
        head.next = null;
        temp.next = head;
        return newHead;
    }
}
