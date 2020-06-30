package leetcode.CQueue;

import java.util.Stack;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-30 10:24
 * @desc:
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

 */
public class CQueue {

    private static Stack<Integer> stack1;
    private static Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        // 两个栈全为空，入任意一栈即可
        if(stack1.isEmpty() && stack2.isEmpty()){
            stack1.push(value);
        } else {
            moveStack(stack1,stack2);
            stack1.push(value);
            moveStack(stack2,stack1);
//            // 栈1空，则栈2非空
//            if(stack1.isEmpty()){
//                moveStack(stack2,stack1);
//                stack2.push(value);
//                moveStack(stack1,stack2);
//            } else { // 栈1非空，栈2空
//                stack1.push(value);
//                moveStack(stack1,stack2);
//            }
        }
    }

    public int deleteHead() {
        // 两栈都为空
        if(stack1.isEmpty()){
            return -1;
        } else {
            return stack1.pop();
        }
    }

    // 转移栈
    private void moveStack(Stack<Integer> source, Stack<Integer> target){
        while (!source.isEmpty()){
            int temp = source.pop();
            target.push(temp);
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println("=================");
        CQueue cQueue1 = new CQueue();
        System.out.println(cQueue1.deleteHead());
        cQueue1.appendTail(5);
        cQueue1.appendTail(2);
        System.out.println(cQueue1.deleteHead());
        System.out.println(cQueue1.deleteHead());
        System.out.println("=================");
        CQueue cQueue2 = new CQueue();
        System.out.println(cQueue2.deleteHead());
        cQueue2.appendTail(12);
        System.out.println(cQueue2.deleteHead());
        cQueue2.appendTail(10);
        cQueue2.appendTail(9);
        System.out.println(cQueue2.deleteHead());
        System.out.println(cQueue2.deleteHead());
        System.out.println(cQueue2.deleteHead());
        cQueue2.appendTail(20);
        System.out.println(cQueue2.deleteHead());
        cQueue2.appendTail(1);
        cQueue2.appendTail(8);
        cQueue2.appendTail(20);
        cQueue2.appendTail(1);
        cQueue2.appendTail(11);
        cQueue2.appendTail(2);
        System.out.println(cQueue2.deleteHead());
        System.out.println(cQueue2.deleteHead());
        System.out.println(cQueue2.deleteHead());
        System.out.println(cQueue2.deleteHead());
    }
}
