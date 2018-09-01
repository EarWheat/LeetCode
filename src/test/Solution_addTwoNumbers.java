package test;

/**
 * @author liuzhaolu
 * @version create_time：2018/9/1 类说明:
 */

import UtilClass.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution_addTwoNumbers {

    public static void main(String args[]){
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        ListNode curNode = listNode;
        while (curNode != null){
            System.out.println("-----"+curNode.data);
            curNode = curNode.next;
        }
    }
}
