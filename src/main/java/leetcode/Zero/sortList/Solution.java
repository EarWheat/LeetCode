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
        return null;
    }

    public void nodeSwap(ListNode pre, ListNode a, ListNode b){
        // pre -> a -> b -> temp
        if(a.val > b.val){
            pre.next = b;
            a.next = b.next;
            b.next = a;
        }
    }
}
