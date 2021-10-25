package leetcode.History.divideCoin;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-08 17:15
 * @desc:有1分，2分，5分，10分四种硬币，每种硬币数量无限，给定n分钱(n <= 100000)，有多少中组合可以组成n分钱？
 */
public class Solution {
    private int calculateWays(int v[],int n){
        int dp[] = new int[n];
        dp[0] = 0;
        int j = 0;
        for(int i = 1;i<n;i++){
            if(i==1){
                j = 0;
            }
            if(i==2){
                j =1;
            }
            if(i==3){
                j = 2;
            }
            if(i==5){
                j=3;
            }
            if(i-1>=0&&i-v[j]>=0){
                dp[i] = dp[i-1]+1 < dp[i-v[j]]+1 ? dp[i-1]+1 : dp[i-v[j]]+1;
            }

        }
        return dp[n-1];
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution solution = new Solution();
        int[] v = {1,2,4,5};
        System.out.println(solution.calculateWays(v,12));
    }
}
