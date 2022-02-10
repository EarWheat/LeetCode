package Interview;

import leetcode.Util.ListNode;
import leetcode.Util.ListNodeUtil;

import java.util.PriorityQueue;

/**
 * @author ：liuzhaolu
 * @description：链表每隔N个节点翻转 input: 1->2->3->4->5->6->7->8 n = 3
 * output: 3->2->1->6->5->4->7->8
 * @prd :
 * @date ：2022/2/9 4:59 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/9 4:59 下午     liuzhaolu       firstVersion
 */
public class NodeTransform {

//    public ListNode transformNode(ListNode head, int n) {
//
//    }

    // 1->2->3->4->5->6->7->8
    public ListNode nodeReverse(ListNode head){
        if(head == null){
            return head;
        }
        ListNode preNode = head;
        ListNode index = preNode.next;
        while (index != null){
            ListNode nextNode = index.next;
            index.next = preNode;
            preNode = index;
            index = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        node1.next = node2;
//        node2.next = node3;
//        NodeTransform nodeTransform = new NodeTransform();
//        ListNode newHead = nodeTransform.nodeReverse(node1);
//        ListNodeUtil.printNode(newHead);
        NodeTransform nodeTransform = new NodeTransform();
        nodeTransform.findKthLargest(new int[]{3,4,5,6,2,1}, 3);

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que=new PriorityQueue<>((a, b)->a-b);
        for(int i=0;i<nums.length;i++){
            que.offer(nums[i]);
            if(que.size()>k){
                que.poll();
            }
        }
        return que.poll();
    }

}
