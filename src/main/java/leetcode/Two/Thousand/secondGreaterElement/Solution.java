package leetcode.Two.Thousand.secondGreaterElement;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/12/12 6:06 PM
 * @Version: 1.initial version; 2023/12/12 6:06 PM
 */
public class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums.length; ++i) {
            while (!pq.isEmpty() && pq.peek()[0] < nums[i]) {
                res[pq.poll()[1]] = nums[i];
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                pq.offer(new int[]{nums[stack.peek()], stack.peek()});
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        //1，获取并转换上次登录时间
        Instant instant = Instant.ofEpochMilli(1701847431000L);
        LocalDateTime givenTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        // 2，获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(ChronoUnit.DAYS.between(givenTime, currentTime));
    }
}