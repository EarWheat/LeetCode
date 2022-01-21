package leetcode.Six.rotateRight;

import leetcode.Util.ListNode;

/**
 * @author ：liuzhaolu
 * @description：61. 旋转链表
 * @prd : https://leetcode-cn.com/problems/rotate-list/
 * @date ：2022/1/20 7:20 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/20 7:20 下午     liuzhaolu       firstVersion
 */
public class Solution {
    // 0 -> 1 -> 2   4
    public ListNode rotateRight(ListNode head, int k) {
        // 只有一个节点
        if(head == null || head.next == null){
            return head;
        }
        // 形成环,并记录长度
        ListNode temp = head;
        int length = 1;
        while (temp.next != null){
            temp = temp.next;
            length++;
        }
        temp.next = head;
        // 寻找新的断点;
        int index = length - (k % length);
        int i = 1;
        ListNode preResult = head;
        ListNode result = preResult.next;
        while (i < index){
            preResult = result;
            result = result.next;
            i++;
        }
        // 端点
        preResult.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node0.next = node1;
        node1.next = node2;
        Solution solution = new Solution();
        solution.rotateRight(node0, 4);
    }
}
