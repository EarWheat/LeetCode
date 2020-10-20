package leetcode.History.reverseKGroup;

import UtilClass.ListNode;

import java.util.Stack;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-16 20:21
 * @desc:
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 

示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

 

说明：

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

 */
public class reverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0){
            return head;
        }
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
            if(stack.size() == k){
                while (stack.size() > 0){
                    p.next = stack.pop();
                    p = p.next;
                }
            }
        }
        // 剩余的位置不需要反转
        Stack<ListNode> stackTemp = new Stack<>();
        while (!stack.isEmpty()){
            stackTemp.push(stack.pop());
        }
        while (!stackTemp.isEmpty()){
            p.next = stackTemp.pop();
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        System.out.println(reverseKGroup(node1,2));
    }
}
