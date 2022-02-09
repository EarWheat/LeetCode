package leetcode.Two.Thousand.countKDifference;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：2006. 差的绝对值为 K 的数对数目
 * @prd : https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/
 * @date ：2022/2/9 11:41 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/9 11:41 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public int countKDifference(int[] nums, int k) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countKDifference(new int[]{1,2,2,1},1));
    }
}
