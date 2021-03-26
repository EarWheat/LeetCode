package leetcode.Zero.deleteDuplicatesV1;

import leetcode.Util.ListNode;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/26 下午1:59
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null){
            if(temp.next != null && temp.next.val == temp.val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
