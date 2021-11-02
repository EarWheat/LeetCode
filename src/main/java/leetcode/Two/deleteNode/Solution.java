package leetcode.Two.deleteNode;

import leetcode.Util.ListNode;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/2 3:20 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/2      liuzhaolu       firstVersion
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode nodeNext = node.next;

        node.val = nodeNext.val;
        node.next = nodeNext.next;
        node = node.next;
    }
}
