package leetcode.longestValidParentheses;

import java.util.Stack;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-04 15:04
 * @desc:
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:
* dp
* 0   1   2   3
* 0   0

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

* 思路：
* 动态规划
* 当前最长有效括号子串是前面最长有效字串的长度，加上该点的字符后所能组成的有效长度的最大值。
* dp[i] = isValidParentheses(s.substring(i - 2 - dp[i-1], i)) ? dp[i - 1] + 1 : dp[i -1]
* 举例：)()())
*      123456
* dp[0] = 0;
* dp[1] = 0;
* dp[2] = isValidParentheses(s.substring(2 - 2 - 0, 2) ? dp[1] + 2 : dp[1]   = isValidParentheses(")(") ? 2 : 0 = 0;
* dp[3] = isValidParentheses(s.substring(3 - 2 - 0, 3) ? dp[2] + 2 : dp[2]   = isValidParentheses("()") ? 2 : 0 = 2;
* dp[4] = isValidParentheses(s.substring(4 - 2 - 2, 4) ? dp[3] + 2 : dp[3]   = isValidParentheses(")()(") ? 2 + 2 : 2 = 2;
* dp[5] = isValidParentheses(s.substring(5 - 2 - 2, 5) ? dp[4] + 2 : dp[4]   = isValidParentheses("()()") ? 2 + 2 : 2 = 4;
*
*
* ()(((()((())
* 1234567890
* dp[0] = 0;
* dp[1] = 0;
* dp[2] = 2;
* dp[3] =
 */
public class longestValidParentheses {
    public static int longestValidParentheses(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= s.length() ;i ++){
            if(i - 2 - dp[i -1] < 0){
                dp[i] = dp[i - 1];
            } else {
                if(isValidParentheses(s.substring(i - 2 - dp[i -1], i))){
                    dp[i] = dp[i - 1] + 2;
                    // 往前追溯
                    int end = i - dp[i];
                    while (end > 0){
                        int length = dp[end];  // 往前追溯多少
                        if(isValidParentheses(s.substring(end - length, end))){
                            dp[i] = dp[i] + dp[end];
                            end = end - length;
                        } else {
                            break;
                        }
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }



    public static boolean isValidParentheses(String s){
        if(s.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')'){
                if(stack.size() == 0) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(longestValidParentheses("(()"));   // 2
//        System.out.println(longestValidParentheses(")()())"));   // 4
//        System.out.println(longestValidParentheses("())()()(")); // 4
//        System.out.println(longestValidParentheses("()(()())")); // 8
//        System.out.println(longestValidParentheses(")("));   // 0
//        System.out.println(longestValidParentheses("()(((()((())"));    // 4
//        System.out.println(longestValidParentheses("()()(()())")); // 10
//        System.out.println(longestValidParentheses("(())(()())")); // 10
//        System.out.println(longestValidParentheses(")()((()())")); // 6
//        System.out.println(longestValidParentheses("())(()())")); // 6
//        System.out.println(longestValidParentheses(")(((((()())()()))()(()))(")); // 22
//        System.out.println(longestValidParentheses("(((((()())()()))()(()))")); // 22
//        System.out.println(longestValidParentheses("((((()()()))()(()))")); // 18
//        System.out.println(longestValidParentheses("(((())()(()))"));// 12
        System.out.println(longestValidParentheses("((())()(()))")); // 12
    }

}
