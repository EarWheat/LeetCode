package leetcode.Six.findNumberOfLIS;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/20 8:23 上午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    // 1, 3, 5, 4;   -> 2    1,3,5    1,3,4     dp[i - 1]
    // 1, 3, 5, 3;   -> 1    1,3,5              dp[i - 1]
    // 1, 2, 5, 4;   -> 2                       dp[i - 1] + 1
    // 1, 2, 5, 3;   -> 2                       dp[i - 1] + 1;
    // 1, 2, 5, 1;   -> 1                       dp[i - 1]
    // 1, 6, 5, 4;   -> 3    1,6    1,5     1,4 dp[i - 1] + 1
    // 1, 6, 5, 3;   -> 3    1,6    1,5     1,3 dp[i - 1] + 1
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0, ans = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; // 重置计数
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i]; // 重置计数
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}
