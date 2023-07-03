package leetcode.Four.addTwoNumbers;

import leetcode.Util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
//
//
// 示例1：
//
//
//
//
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
//
//
// 示例2：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
//
//
// 示例3：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 链表的长度范围为 [1, 100]
// 0 <= node.val <= 9
// 输入数据保证链表代表的数字无前导 0
//
//
//
//
// 进阶：如果输入链表不能翻转该如何解决？
// Related Topics 栈 链表 数学 👍 645 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @Desc: 445. 两数相加 II
 * @Author: 泽露
 * @Date: 2023/7/3 3:34 PM
 * @Version: 1.initial version; 2023/7/3 3:34 PM
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}
