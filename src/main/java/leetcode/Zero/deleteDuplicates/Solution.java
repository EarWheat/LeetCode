package leetcode.Zero.deleteDuplicates;

import com.alibaba.fastjson.JSONObject;
import leetcode.Util.ListNode;
import leetcode.Util.ListNodeUtil;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/25 上午7:43
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    /**
     * 双指针
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        while (head != null && head.next != null && head.next.val == head.val){
            int temp = head.val;
            while (head != null && head.val == temp){
                head = head.next;
            }
        }
        if(head == null || head.next == null){
            return head;
        }
        ListNode preNode = head;
        ListNode current = preNode.next;
        while (current != null && current.next != null){
            if(current.val == current.next.val){
                ListNode tempNode = findNextDifNode(current);
                preNode.next = tempNode;
                current = tempNode;
            } else {
                // 一起右移动
                preNode = preNode.next;
                current = current.next;
            }
        }
        return head;
    }

    public ListNode findNextDifNode(ListNode current){
        int temp = current.val;
        while (current != null && current.val == temp){
            current = current.next;
        }
        return current;
    }

    public static void main(String[] args) {
//        ListNode head = ListNodeUtil.array2ListNode(new int[]{1,2,3,3,4,4,5});
//        ListNode head = ListNodeUtil.array2ListNode(new int[]{1,1,1,2,3});
//        ListNode head = ListNodeUtil.array2ListNode(new int[]{1,1,1,2,2});
        ListNode head = ListNodeUtil.array2ListNode(new int[]{1,2,2});
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.deleteDuplicates(head)));
    }
}
