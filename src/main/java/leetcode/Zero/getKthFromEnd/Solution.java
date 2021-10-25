package leetcode.Zero.getKthFromEnd;

import leetcode.Util.ListNode;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/2 10:09 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode frontNode = head, behindNode = head;
        while (frontNode != null && k > 0) {

            frontNode = frontNode.next;
            k--;
        }

        while (frontNode != null) {

            frontNode = frontNode.next;
            behindNode = behindNode.next;
        }

        return behindNode;
    }
}
