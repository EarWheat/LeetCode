package leetcode.One.evalRPN;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/20 上午7:25
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Map map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        for (String token : tokens) {
            if (token.equals("+")) {
                if (!stack.isEmpty()) {
                    num1 = stack.pop();
                }
                if (!stack.isEmpty()) {
                    num2 = stack.pop();
                }
                stack.add(num1 + num2);
                continue;
            }
            if (token.equals("-")) {
                if (!stack.isEmpty()) {
                    num1 = stack.pop();
                }
                if (!stack.isEmpty()) {
                    num2 = stack.pop();
                }
                stack.add(num2 - num1);
                continue;
            }
            if (token.equals("*")) {
                if (!stack.isEmpty()) {
                    num1 = stack.pop();
                }
                if (!stack.isEmpty()) {
                    num2 = stack.pop();
                }
                stack.add(num1 * num2);
                continue;
            }
            if (token.equals("/")) {
                if (!stack.isEmpty()) {
                    num1 = stack.pop();
                }
                if (!stack.isEmpty()) {
                    num2 = stack.pop();
                }
                if (num2 == 0) {
                    continue;
                }
                stack.add(num2 / num1);
                continue;
            }
            stack.add(Integer.valueOf(token));
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"4","13","5","/","+"};
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(tokens));
    }
}
