package leetcode.One.reorderList;

import java.util.Stack;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-20 09:49
 * @desc
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class reorderList {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

   /*
   1->2->3->4->5 1->5->2->4->3
    */
    public static void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        // 找到节点尾部
        ListNode tail = head;
        Stack<ListNode> stack = new Stack<>();
        while (tail != null){
            stack.add(tail);
            tail = tail.next;
        }
        ListNode temp = head;
        ListNode index = stack.pop();
        int length = stack.size();
        int endLength = 0;
        while (temp != index){
            // 置换成尾部
            index.next = temp.next;
            temp.next = index;
            temp = index.next;
            index = stack.pop();
            endLength++;
            if(endLength > length / 2){
                break;
            }
        }
        temp.next = null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reorderList(listNode1);
        System.out.println(listNode1.next.val);
    }
}
