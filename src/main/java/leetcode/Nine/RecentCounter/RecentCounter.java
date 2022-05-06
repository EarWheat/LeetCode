package leetcode.Nine.RecentCounter;

import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/6 3:48 PM
 * @Version: 1.initial version; 2022/5/6 3:48 PM
 */
public class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }


}
