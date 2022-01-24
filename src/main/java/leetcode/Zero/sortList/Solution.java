package leetcode.Zero.sortList;

import leetcode.Util.ListNode;

/**
 * @author ：liuzhaolu
 * @description：剑指 Offer II 077. 链表排序
 * @prd : https://leetcode-cn.com/problems/7WHec2/
 * @date ：2022/1/9 6:21 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/9 6:21 下午     liuzhaolu       firstVersion
 */
public class Solution {

    public ListNode sortList(ListNode head) {
       ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
       ListNode headNext = null;
       while (head != null){
           headNext = head.next;
           head.next = null;
           if(fakeHead.next == null){
               fakeHead.next = head;
               head = headNext;
               continue;
           }
           ListNode temp = fakeHead.next;
           ListNode preNode = fakeHead;
           while (temp != null){
               if(head.val < temp.val){
                   preNode.next = head;
                   head.next = temp;
                   break;
               }
               preNode = preNode.next;
               temp = temp.next;
           }
           if(temp == null){
               preNode.next = head;
           }
           head = headNext;
       }
       return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node5.next = node4;
        node4.next = node2;
        node2.next = node3;
        node3.next = node1;
        Solution solution = new Solution();
        solution.sortList(node5);

    }
}
