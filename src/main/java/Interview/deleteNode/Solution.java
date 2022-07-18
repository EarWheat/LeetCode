package Interview.deleteNode;

import leetcode.Util.ListNode;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/18 6:01 PM
 * @Version: 1.initial version; 2022/7/18 6:01 PM
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return head;
        }
        if(head.val == val){
            return head.next;
        }
        ListNode preNode = head;
        ListNode temp = preNode.next;
        while (temp != null){
            if(temp.val == val){
                preNode.next = temp.next;
            }
            preNode = temp;
            temp = temp.next;
        }
        return head;
    }
}
