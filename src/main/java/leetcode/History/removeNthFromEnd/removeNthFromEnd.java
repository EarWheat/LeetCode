package leetcode.History.removeNthFromEnd;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-31 17:17
 * @desc:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

思路：
* 空间换效率呗，另开辟一个节点，始终保持n个长度
* 双指针，前后指针间隔n;
* n = 2
* i -> 1;
* j -> 3
*
* n = 3;
* i -> 1;
* j -> 4;
 */
public class removeNthFromEnd {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node_i = head;
        ListNode node_j = head;
        ListNode result = node_i;
        for(int i = 0; i < n;i++){
            node_j = node_j.next;
        }
        if(node_j == null){
            return node_i.next;
        }
        while (node_j != null){
            if(node_j.next == null){
                ListNode next = node_i.next;
                node_i.next = next.next;
                break;
            }
            node_j = node_j.next;
            node_i = node_i.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        // case1:
        // 1 -> 2    n = 2
        node1.next = node2;
        ListNode result = removeNthFromEnd(node1,2);
        // case2:
        // 1         n = 1
        ListNode newNode = removeNthFromEnd(new ListNode(1),1);
//        System.out.println(removeNthFromEnd(node1,2));
        System.out.println("-------");
    }
}
