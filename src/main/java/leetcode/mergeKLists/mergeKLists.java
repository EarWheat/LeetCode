package leetcode.mergeKLists;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-26 10:50
 * @desc:
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

 */

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class mergeKLists {
    public static void main(String[] args) {
        ListNode t1_node1 = new ListNode(1);
        ListNode t1_node2 = new ListNode(2);
        ListNode t1_node3 = new ListNode(3);
        ListNode t1_node4 = new ListNode(4);
        ListNode t1_node5 = new ListNode(5);
        t1_node1.next = t1_node4;
        t1_node4.next = t1_node5;
        ListNode test1 = t1_node1;
        ListNode t2_node1 = new ListNode(1);
        ListNode t2_node2 = new ListNode(2);
        ListNode t2_node3 = new ListNode(3);
        ListNode t2_node4 = new ListNode(4);
        ListNode t2_node5 = new ListNode(5);
        ListNode t2_node6 = new ListNode(6);
        ListNode t3_node1 = new ListNode(1);
        ListNode t3_node2 = new ListNode(2);
        ListNode t3_node6 = new ListNode(6);
        ListNode t4_node1 = new ListNode(1);
        ListNode t4_node2 = new ListNode(2);
        ListNode t4_node3 = new ListNode(3);
        ListNode t4_node4 = new ListNode(4);
        ListNode t4_node5 = new ListNode(5);
        ListNode t4_node6 = new ListNode(6);
        t2_node1.next = t2_node3;
        t2_node3.next = t2_node4;
        ListNode test2 = t2_node1;
        t3_node2.next = t3_node6;
        ListNode test3 = t3_node2;
        t4_node1.next = t4_node5;
        t4_node5.next = t4_node6;
        ListNode test4 = t4_node1;
//        ListNode[] lists = {test1,test2,test3,test4};
        ListNode[] lists = {};
        showListNode(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        // 分治法,只剩两个节点
        if(lists.length == 2){
            Queue<Integer> queue = new LinkedList<>();
            ListNode node1 = lists[0];
            ListNode node2 = lists[1];
            while (node1 != null || node2 != null){
                if(node1 == null){
                    queue.addAll(getLast(node2));
                    break;
                }
                if(node2 == null){
                    queue.addAll(getLast(node1));
                    break;
                }
                if(node1.val <= node2.val){
                    queue.add(node1.val);
                    node1 = node1.next;
                } else {
                    queue.add(node2.val);
                    node2 = node2.next;
                }
            }

            List<ListNode> result = new ArrayList<>();
            while (queue.size() != 0){
                int val = queue.poll();
                ListNode temp = new ListNode(val);
                result.add(temp);
            }
            for(int i = 0 ; i < result.size() - 1; i++){
                result.get(i).next = result.get(i+1);
            }
            if(result.size() < 1){
                return null;
            }
            return result.get(0);
        }
        // 二分
        int index = lists.length / 2;
        ListNode[] left = Arrays.copyOfRange(lists,0,index);
        ListNode[] right = Arrays.copyOfRange(lists,index,lists.length);
        ListNode l = mergeKLists(left);
        ListNode r = mergeKLists(right);
        ListNode[] result = {l,r};
        return mergeKLists(result);
    }

    // 获取ListNode剩余
    private static Queue<Integer> getLast(ListNode node){
        Queue<Integer> queue = new LinkedList<>();
        while (node != null){
            queue.add(node.val);
            node = node.next;
        }
        return queue;
    }

    // 展示list
    private static void showListNode(ListNode node){
        while (node != null){
            System.out.print(node.val);
            if(node.next != null){
                System.out.print("->");
            }
            node = node.next;
        }
    }

}
