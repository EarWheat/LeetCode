package leetcode.Eight.shortestSubarray;
//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回
//-1 。
//
// 子数组 是数组中 连续 的一部分。
// 示例 1：

//输入：nums = [1], k = 1
//输出：1
//
//
// 示例 2：
//
//
//输入：nums = [1,2], k = 4
//输出：-1
//
//
// 示例 3：
//
//
//输入：nums = [2,-1,2], k = 3
//输出：3
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁵ <= nums[i] <= 10⁵
// 1 <= k <= 10⁹
//
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 526 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/10/26 2:06 PM
 * @Version: 1.initial version; 2022/10/26 2:06 PM
 */
public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }
        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSumArr[i];
            while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }
}
