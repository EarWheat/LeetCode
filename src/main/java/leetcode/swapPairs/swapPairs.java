package leetcode.swapPairs;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-26 15:24
 * @desc:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.

 */
public class swapPairs {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode temp = swapPairs(next.next);
        // 1->temp
        head.next = temp;
        // 2->1
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
        ListNode result = swapPairs(node1);
        ListNode result2 = swapPairs(node3);
        System.out.println(result.val);
    }
}
