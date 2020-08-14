package leetcode.mergeTwoLists;

import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-14 11:49
 * @desc:
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

 */
public class mergeTwoLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * @param l1
     * @param l2
     * @return
     * 1->2->4, 1->3->4
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    // 要用递归实现
    public static ListNode getListNodeStr(int[] nodes){
        if(nodes.length == 0){
            return null;
        }
        if(nodes.length <= 1){
            return new ListNode(nodes[0]);
        }
        ListNode root = new ListNode(nodes[0]);
        root.next = getListNodeStr(Arrays.copyOfRange(nodes,1,nodes.length));
        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = getListNodeStr(new int[]{1,2,4});
        ListNode l2 = getListNodeStr(new int[]{5});
        ListNode result = mergeTwoLists(l2,l1);
        ListNode l3 = getListNodeStr(new int[]{1,3,4});
        ListNode l4 = getListNodeStr(new int[]{1,2,4});
        result = mergeTwoLists(l3,l4);
        ListNode l5 = null;
        ListNode l6 = null;
        result = mergeTwoLists(l5,l6);
        System.out.println("-----");
    }
}
