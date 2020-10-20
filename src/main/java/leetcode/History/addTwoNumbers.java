package leetcode.History;

import UtilClass.ListNode;

/**
 * @author liuzhaolu
 * @version create_time：2018/11/11 类说明:    两数相加
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
public class addTwoNumbers {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int other = 0;
        while (l1 != null || l2 != null){
            int num1 = l1 == null ? 0 : l1.data;
            int num2 = l2 == null ? 0 : l2.data;
            int sum = num1 + num2 + other;
            other = sum >= 10 ? 1 : 0;
            temp.next = new ListNode(sum % 10 );
            temp = temp.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(other == 1){
            temp.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(3);
//        node1.next = node2;
//        node2.next = node3;
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
//        ListNode l3 = new ListNode(4);
        l1.next = l2;
//        l2.next = l3;
        ListNode result = addTwoNumbers(node1,l1);
    }

}
