package leetcode.Five.change;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/10 下午5:15
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
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

    public int changeV2(int amount, int[] coins){
        int result = 0;
        if(coins.length == 1){
            if(amount % coins[0] == 0){
                return 1;
            } else {
                return 0;
            }
        }
        for (int i = 0; i < coins.length; i++) {
            if(amount == coins[i]){
                result++;
                break;
            }
            if(amount > coins[i]){
                result += changeV2(amount - coins[i], coins);
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.change(5,new int[]{1,2,5}));
    }
}
