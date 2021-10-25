package leetcode.Zero.getIntersectionNode;

import leetcode.Util.ListNode;
import leetcode.Util.ListNodeUtil;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/21 下午7:23
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null || headB != null){
            if(headA == headB){
                return headA;
            } else {
                if (set.contains(headA)){
                    return headA;
                } else {
                    if(headA != null){
                        set.add(headA);
                        headA = headA.next;
                    }
                }
                if (set.contains(headB)){
                    return headB;
                } else {
                    if(headB != null){
                        set.add(headB);
                        headB = headB.next;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        ListNode node_5_1 =new ListNode(5);
        ListNode node_0 = new ListNode(0);
//        ListNode node_4_1 = new ListNode(4);
//        ListNode node_1_1 = new ListNode(1);
//        ListNode node_1_2 = new ListNode(1);
        ListNode node_9 = new ListNode(9);
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
//        ListNode node_4_2 = new ListNode(4);
//        ListNode node_5_2 = new ListNode(5);
//        node_5_1.next = node_0;
////        node_0.next = node_1_1;
////        node_1_1.next = node_8;
////        node_8.next = node_4_2;
////        node_4_2.next = node_5_2;
////        node_4_1.next = node_1_2;
////        node_1_2.next = node_8;
        node_0.next = node_9;
        node_9.next = node_1;
        node_1.next = node_2;
        node_2.next = node_4;
        node_3.next = node_2;
        Solution solution = new Solution();
        System.out.println(solution.getIntersectionNode(node_0,node_3));
    }
}
