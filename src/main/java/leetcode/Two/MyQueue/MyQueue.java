package leetcode.Two.MyQueue;

import java.util.Stack;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2024/3/4 3:06 PM
 * @Version: 1.initial version; 2024/3/4 3:06 PM
 */
public class MyQueue {

    Stack<Integer> stackA;
    Stack<Integer> stackB;

    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
    }

    public int pop() {
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

    public int peek() {
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.peek();
    }

    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}
