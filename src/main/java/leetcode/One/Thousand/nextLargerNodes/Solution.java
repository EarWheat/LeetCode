package leetcode.One.Thousand.nextLargerNodes;

import leetcode.Util.ListNode;

import java.util.*;
//给定一个长度为 n 的链表 head
//
// 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
//
// 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
//，设置 answer[i] = 0 。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [2,1,5]
//输出：[5,5,0]
//
//
// 示例 2：
//
//
//
//
//输入：head = [2,7,4,3,5]
//输出：[7,0,5,5,0]
//
//
//
//
// 提示：
//
//
// 链表中节点数为 n
// 1 <= n <= 10⁴
// 1 <= Node.val <= 10⁹
//
// Related Topics 栈 数组 链表 单调栈 👍 269 👎 0
/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/4/10 12:05 PM
 * @Version: 1.initial version; 2023/4/10 12:05 PM
 */
public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ans = new ArrayList<Integer>();
        Deque<int[]> stack = new ArrayDeque<int[]>();

        ListNode cur = head;
        int idx = -1;
        while (cur != null) {
            ++idx;
            ans.add(0);
            while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                ans.set(stack.pop()[1], cur.val);
            }
            stack.push(new int[]{cur.val, idx});
            cur = cur.next;
        }

        int size = ans.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode5 = new ListNode(5);
        listNode2.next = listNode1;
        listNode1.next = listNode5;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.nextLargerNodes(listNode2)));
    }

}
