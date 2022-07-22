package Interview.MinStack;

import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/22 2:34 PM
 * @Version: 1.initial version; 2022/7/22 2:34 PM
 */
public class MinStack {

    Stack<Integer> stack;
    List<Integer> list;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }

    public void push(int x) {
        stack.push(x);
        list.add(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(pop)){
                iterator.remove();
                break;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        for(Integer i : list){
            min = Math.min(i, min);
        }
        return min;
    }
}
