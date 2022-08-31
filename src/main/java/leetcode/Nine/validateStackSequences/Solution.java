package leetcode.Nine.validateStackSequences;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Desc: 946 验证栈序列
 * @Author: 泽露
 * @Date: 2022/8/31 5:25 PM
 * @Version: 1.initial version; 2022/8/31 5:25 PM
 */
public class Solution {
    // pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        int index = 0;
        while (index < pushed.length){
            if(stack.isEmpty() || stack.peek() != popped[popIndex]){
                stack.push(pushed[index]);
                index++;
            } else {
                stack.pop();
                popIndex++;
            }
        }
        while (!stack.isEmpty() && stack.peek() == popped[popIndex]){
            stack.pop();
            popIndex++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,2,1}));
    }
}
