package leetcode.Zero.partition;

import leetcode.Util.ListNode;

import java.lang.annotation.Inherited;

/**
 * @author ：liuzhaolu
 * @description：86. 分隔链表
 * @prd : https://leetcode-cn.com/problems/partition-list/
 * @date ：2022/2/16 2:04 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/16 2:04 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode minHead = null;
        ListNode minTemp = null;
        ListNode maxHead = null;
        ListNode maxTemp = null;
        while (head != null){
            if(head.val >= x){
                if(maxHead == null){
                    maxHead = head;
                    maxTemp = maxHead;
                } else {
                    maxTemp.next = head;
                    maxTemp = maxTemp.next;
                }
            } else {
                if(minHead == null){
                    minHead = head;
                    minTemp = minHead;
                } else {
                    minTemp.next = head;
                    minTemp = minTemp.next;
                }
            }
            head = head.next;
        }
        if(maxTemp != null){
            maxTemp.next = null;
        }
        if(minTemp != null){
            minTemp.next = maxHead;
        }
        if(minHead == null && maxHead != null){
            return maxHead;
        }
        return minHead;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node4 = new ListNode(4);
//        ListNode node3 = new ListNode(3);
//        ListNode node2 = new ListNode(2);
//        ListNode node5 = new ListNode(5);
//        ListNode node2_ = new ListNode(2);
//        node1.next = node4;
//        node4.next = node3;
//        node3.next = node2;
//        node2.next = node5;
//        node5.next = node2_;
        Solution solution = new Solution();
        ListNode head = solution.partition(node1, 0);
        System.out.println(head.val);

    }
}
