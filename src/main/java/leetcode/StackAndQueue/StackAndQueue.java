package leetcode.StackAndQueue;

import java.util.Stack;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-14 10:51
 * @desc:用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class StackAndQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (stack1.size() != 1){
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int result = stack1.pop();
        while (!stack2.isEmpty()){
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return result;
    }
}
