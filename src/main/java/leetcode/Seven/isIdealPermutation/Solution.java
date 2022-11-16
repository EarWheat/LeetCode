package leetcode.Seven.isIdealPermutation;
//给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
//
// 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
//
//
// 0 <= i < j < n
// nums[i] > nums[j]
//
//
// 局部倒置 的数目等于满足下述条件的下标 i 的数目：
//
//
// 0 <= i < n - 1
// nums[i] > nums[i + 1]
//
//
// 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,0,2]
//输出：true
//解释：有 1 个全局倒置，和 1 个局部倒置。
//
//
// 示例 2：
//
//
//输入：nums = [1,2,0]
//输出：false
//解释：有 2 个全局倒置，和 1 个局部倒置。
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 10⁵
// 0 <= nums[i] < n
// nums 中的所有整数 互不相同
// nums 是范围 [0, n - 1] 内所有数字组成的一个排列
//
// Related Topics 数组 数学 👍 131 👎 0

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/11/16 11:32 AM
 * @Version: 1.initial version; 2022/11/16 11:32 AM
 */
public class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int limit = 0;
        int all = 0;
        for (int i = 1; i < nums.length; i++) {
            // 求limit
            if (nums[i] < nums[i - 1]) {
                limit++;
            }
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    all++;
                }
            }
        }
        return all == limit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIdealPermutation(new int[]{1, 2, 0}));
    }

}
