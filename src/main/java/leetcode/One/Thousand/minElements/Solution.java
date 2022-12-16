package leetcode.One.Thousand.minElements;
//给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
//
// 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
//
//
// 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,-1,1], limit = 3, goal = -4
//输出：2
//解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
//
//
// 示例 2：
//
//
//输入：nums = [1,-10,9,1], limit = 100, goal = 0
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= limit <= 10⁶
// -limit <= nums[i] <= limit
// -10⁹ <= goal <= 10⁹
//
// Related Topics 贪心 数组 👍 40 👎 0

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/12/16 5:45 PM
 * @Version: 1.initial version; 2022/12/16 5:45 PM
 */
public class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        int sum = Arrays.stream(nums).sum();
        int gap = goal - sum;
        return addTimes(gap, limit);
    }

    public int addTimes(int goal, int limit) {
        int result = 0;
        goal = Math.abs(goal);
        while (goal > 0) {
            goal -= limit;
            result++;
        }
        return result;
    }

    public int answer(int[] nums, int limit, int goal){
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long diff = Math.abs(sum - goal);
        return (int) ((diff + limit - 1) / limit);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minElements());
    }
}
