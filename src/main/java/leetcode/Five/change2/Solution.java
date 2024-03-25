package leetcode.Five.change2;

/**
 * @Desc: 零钱兑换
 * @Author: 泽露
 * @Date: 2024/3/25 12:50 PM
 * @Version: 1.initial version; 2024/3/25 12:50 PM
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
