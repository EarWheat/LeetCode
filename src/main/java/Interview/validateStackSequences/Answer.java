package Interview.validateStackSequences;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/6 6:10 PM
 * @Version: 1.initial version; 2022/6/6 6:10 PM
 */
public class Answer {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
