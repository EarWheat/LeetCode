package leetcode.Zero.reverseList;

import com.alibaba.fastjson.JSON;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-23 19:09
 * @desc 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class reverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        //5->4->3->2
        ListNode temp = head.next;
        ListNode newHead = reverseList(head.next);
        head.next = null;
        temp.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode newNode = reverseList(node1);
        System.out.println(JSON.toJSONString(newNode));
    }
}
