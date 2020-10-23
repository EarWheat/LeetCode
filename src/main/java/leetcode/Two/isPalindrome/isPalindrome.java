package leetcode.Two.isPalindrome;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-23 10:31
 * @desc 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class isPalindrome {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 链表使用快慢指针即可找到中间节点。
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        if(fast != null){ // 链表长度为奇数
            slow = slow.next;
        }
        while (slow != null){
            list1.add(head.val);
            list2.add(slow.val);
            head = head.next;
            slow = slow.next;
        }
        for(int i = 0; i < list1.size();i++){
            if(!list1.get(i).equals(list2.get(list2.size() - 1 - i))){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(-129);
        ListNode node2 = new ListNode(-129);
//        ListNode node3 = new ListNode(-3);
//        ListNode node4 = new ListNode(-2);
//        ListNode node5 = new ListNode(-1);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        System.out.println(isPalindrome(node1));
    }
}
