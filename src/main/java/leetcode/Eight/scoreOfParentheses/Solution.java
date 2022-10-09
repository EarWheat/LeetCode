package leetcode.Eight.scoreOfParentheses;
//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
//
//
// () 得 1 分。
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。
//
//
//
//
// 示例 1：
//
// 输入： "()"
//输出： 1
//
//
// 示例 2：
//
// 输入： "(())"
//输出： 2
//
//
// 示例 3：
//
// 输入： "()()"
//输出： 2
//
//
// 示例 4：
//
// 输入： "(()(()))"
//输出： 6
//
//
//
//
// 提示：
//
//
// S 是平衡括号字符串，且只含有 ( 和 ) 。
// 2 <= S.length <= 50
//
// Related Topics 栈 字符串 👍 401 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/10/9 4:59 PM
 * @Version: 1.initial version; 2022/10/9 4:59 PM
 */
public class Solution {
    // (()(()))
    // (1(1))
    // (12)
    // (3)
    //  6
    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<Integer>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.scoreOfParentheses("(()(()))"));
    }
}
