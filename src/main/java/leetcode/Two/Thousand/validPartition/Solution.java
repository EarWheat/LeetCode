package leetcode.Two.Thousand.validPartition;

import java.util.Arrays;

/**
 * @Desc:给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
 *
 * 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
 *
 * 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
 * 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
 * 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
 * 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：nums = [4,4,4,5,6]
 * 输出：true
 * 解释：数组可以划分成子数组 [4,4] 和 [4,5,6] 。
 * 这是一种有效划分，所以返回 true 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,2]
 * 输出：false
 * 解释：该数组不存在有效划分。
 * 提示：
 *
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * Related Topics
 * 数组
 * 动态规划
 *
 * 👍 66
 * 👎 0
 * @Author: 泽露
 * @Date: 2024/3/1 11:45 AM
 * @Version: 1.initial version; 2024/3/1 11:45 AM
 */
public class Solution {
    public boolean validPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        boolean valid2 = isValid(Arrays.copyOfRange(nums, 0, 2));
        boolean valid3 = isValid(Arrays.copyOfRange(nums, 0, 3));
        if (valid2 && valid3) {
            return validPartition(Arrays.copyOfRange(nums,2, nums.length)) || validPartition(Arrays.copyOfRange(nums, 3, nums.length));
        }
        if (valid2) {
            return validPartition(Arrays.copyOfRange(nums,2, nums.length));
        }
        if (valid3) {
            return validPartition(Arrays.copyOfRange(nums,3, nums.length));
        }
        return false;
    }

    public boolean isValid(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        if (nums.length == 2) {
            return nums[1] == nums[0];
        }
        int diffNum = nums[1] - nums[0];
        if (diffNum > 1) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != diffNum) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPartition(new int[]{4,4,4,5,6}));
    }
}
