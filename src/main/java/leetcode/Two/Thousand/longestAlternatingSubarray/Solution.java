package leetcode.Two.Thousand.longestAlternatingSubarray;

/**
 * @Desc:2760. 最长奇偶子数组
 * @Author: 泽露
 * @Date: 2023/11/16 3:53 PM
 * @Version: 1.initial version; 2023/11/16 3:53 PM
 */
public class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0, n = nums.length;
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                if (isSatisfied(nums, l, r, threshold)) {
                    res = Math.max(res, r - l + 1);
                }
            }
        }
        return res;
    }

    public boolean isSatisfied(int[] nums, int l, int r, int threshold) {
        if (nums[l] % 2 != 0) {
            return false;
        }
        for (int i = l; i <= r; i++) {
            if (nums[i] > threshold || (i < r && nums[i] % 2 == nums[i + 1] % 2)) {
                return false;
            }
        }
        return true;
    }
}