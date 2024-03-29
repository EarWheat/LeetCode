package leetcode.One.Thousand.maximumScore2;

/**
 * @Desc: 1793. 好子数组的最大分数
 * @Author: 泽露
 * @Date: 2024/3/19 5:06 PM
 * @Version: 1.initial version; 2024/3/19 5:06 PM
 */
public class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k - 1, right = k + 1;
        int ans = 0;
        for (int i = nums[k];; --i) {
            while (left >= 0 && nums[left] >= i) {
                --left;
            }
            while (right < n && nums[right] >= i) {
                ++right;
            }
            ans = Math.max(ans, (right - left - 1) * i);
            if (left == -1 && right == n) {
                break;
            }
        }
        return ans;
    }
}
