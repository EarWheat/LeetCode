package leetcode.One.Thousand.maxResult;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2024/2/5 3:37 PM
 * @Version: 1.initial version; 2024/2/5 3:37 PM
 */
public class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(0);
        for (int i = 1; i < n; i++) {
            while (queue.peekFirst() < i - k) {
                queue.pollFirst();
            }
            dp[i] = dp[queue.peekFirst()] + nums[i];
            while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return dp[n - 1];
    }
}
