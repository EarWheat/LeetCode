package leetcode.Six.MyCircularQueue;

import java.util.Arrays;

/**
 * @Desc:你的实现应该支持如下操作： MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * 示例：
 * <p>
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * circularQueue.enQueue(1);  // 返回 true
 * circularQueue.enQueue(2);  // 返回 true
 * circularQueue.enQueue(3);  // 返回 true
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * circularQueue.Rear();  // 返回 3
 * circularQueue.isFull();  // 返回 true
 * circularQueue.deQueue();  // 返回 true
 * circularQueue.enQueue(4);  // 返回 true
 * circularQueue.Rear();  // 返回 4
 * @Author: 泽露
 * @Date: 2022/8/2 5:05 PM
 * @Version: 1.initial version; 2022/8/2 5:05 PM
 */
public class MyCircularQueue {

    int val[];
    int l,r,k,count;//l指向头部，r指向头部后，count为节点数
    public MyCircularQueue(int k) {
        this.k=k;
        val=new int[k];
        l=r=count=0;
    }

    public boolean enQueue(int value) {
        if(count==k){return false;}
        val[r]=value;
        r=(r+1)%k;
        count++;
        return true;
    }

    public boolean deQueue() {
        if(count==0){return false;}
        l=(l+1)%k;
        count--;
        return true;
    }

    public int Front() {
        return count==0?-1:val[l];
    }

    public int Rear() {
        return count==0?-1:val[(r-1+k)%k];
    }

    public boolean isEmpty() {
        return count==0;
    }

    public boolean isFull() {
        return count==k;
    }

    public static void main(String[] args) {
//        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//        System.out.println(circularQueue.enQueue(1));  // 返回 true
//        System.out.println(circularQueue.enQueue(2));
//        System.out.println(circularQueue.enQueue(3));
//        System.out.println(circularQueue.enQueue(4));
//        System.out.println(circularQueue.Rear());
//        System.out.println(circularQueue.isFull());
//        System.out.println(circularQueue.deQueue());
//        System.out.println(circularQueue.enQueue(4));
//        System.out.println(circularQueue.Rear());
        MyCircularQueue circularQueue = new MyCircularQueue(8); // 设置长度为 3
        System.out.println(circularQueue.enQueue(3));  // 返回 true
        System.out.println(circularQueue.enQueue(9));  // 返回 true
        System.out.println(circularQueue.enQueue(5));  // 返回 true
        System.out.println(circularQueue.enQueue(0));  // 返回 true
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
//        System.out.println(circularQueue.enQueue(5));
//        System.out.println(circularQueue.Rear());
//        System.out.println(circularQueue.deQueue());
//        System.out.println(circularQueue.Front());
//        System.out.println(circularQueue.deQueue());
//        System.out.println(circularQueue.deQueue());
//        System.out.println(circularQueue.deQueue());
    }
}
