package leetcode.Seven.climbStairs;

/**
 * @author ：liuzhaolu
 * @description：70. 爬楼梯
 * @prd : https://leetcode-cn.com/problems/climbing-stairs/
 * @date ：2022/1/17 2:48 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/17 2:48 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
