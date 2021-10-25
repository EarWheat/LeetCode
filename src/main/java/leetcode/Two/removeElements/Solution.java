package leetcode.Two.removeElements;

import leetcode.Util.ListNode;
import leetcode.Util.ListNodeUtil;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/5 下午1:55
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            if(head.val == val){
                return null;
            } else {
                return head;
            }
        }
        while (head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return head;
        }
        ListNode temp = head.next;
        ListNode preNode = head;
        while (temp != null){
            if(temp.val == val){
                preNode.next = temp.next;
            } else {
                preNode = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7,7,7,7};
        ListNode head = ListNodeUtil.array2ListNode(array);
        Solution solution = new Solution();
        System.out.println(solution.removeElements(head,7));
    }
}
