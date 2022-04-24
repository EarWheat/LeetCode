package Interview.reversePrint;

import leetcode.Util.ListNode;

import java.util.Stack;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/4/24 4:14 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/24 4:14 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.add(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
