package leetcode.Zero.reverseBetweenV2;

import leetcode.Util.ListNode;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/18 下午2:43
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    // 1->2->3->4->5
    // 1->3->4->5->2
    // 1->4->5->3->2
    // 1->5->4->3->2
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        int index = 0;
        ListNode temp = head;
        ListNode preNode = head;
        ListNode leftNode = head;
        ListNode rightNode = head;
        while (temp != null){
            index++;
            if(index == left - 1){
                preNode = temp;
            }
            if(index == left){
                leftNode = temp;
            }
            if(index == right){
                rightNode = temp;
                break;
            }
            temp = temp.next;
        }
        // 1->2->3->4->5
        // 1->3->4->2->5
        // 1->4->2->2->5
        // 1->2->3
        if(leftNode == head){
            head = leftNode.next;
        } else {
            preNode.next = leftNode.next;
        }
        leftNode.next = rightNode.next;
        rightNode.next = leftNode;
        return reverseBetween(head,left,right - 1);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        Solution solution = new Solution();
        solution.reverseBetween(head,1,3);
        System.out.println(head.next);
    }
}
