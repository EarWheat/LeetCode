package leetcode.One.Thousand.maxAlternatingSum;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/7/11 10:58 AM
 * @Version: 1.initial version; 2023/7/11 10:58 AM
 */
public class Solution {
    public long maxAlternatingSum(int[] nums) {
        long even = nums[0], odd = 0;
        for (int i = 1; i < nums.length; i++) {
            even = Math.max(even, odd + nums[i]);
            odd = Math.max(odd, even - nums[i]);
        }
        return even;
    }
}
