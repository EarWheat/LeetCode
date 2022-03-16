package coding;

import leetcode.Util.ListNode;

import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/3/15 6:49 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/15 6:49 下午     liuzhaolu       firstVersion
 */
public class ReversList {

    // A -> B -> C      C->B->A
    public ListNode reversList(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode preNode = listNode;// 1
        ListNode curNode = listNode.next;
        preNode.next = null;// 2
        ListNode postNode = null;   //
        while (curNode != null) {
            postNode = curNode.next;    // cur -> B   post -> c
            curNode.next = preNode;   // B -> A
            preNode = curNode;          // pre -> B
            curNode = postNode;         // cur -> C
        }
        return preNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ReversList reversList = new ReversList();
        ListNode newNode = reversList.reversList(node1);
        while (newNode != null) {
            System.out.print(newNode.val + "->");
            newNode = newNode.next;
        }
    }
}
