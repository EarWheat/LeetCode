package Interview.mergeTwoLists;

import leetcode.Util.ListNode;

/**
 * @author ：liuzhaolu
 * @description：剑指 Offer 25. 合并两个排序的链表
 * @prd : https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @date ：2022/4/25 5:45 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/25 5:45 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1 != null && l2 != null){
            if(l1.val < l2.val){
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
        }
        ListNode temp = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null){
            temp.next = l1;
        }
        if(l2 != null){
            temp.next = l2;
        }
        return head;
    }
}
