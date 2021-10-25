package leetcode.Seven.findCheapestPrice;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/24 8:45 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst){
            return 0;
        }
        if(k < 0){
            return -1;
        }
        if(k == 0){
            for (int i = 0; i < flights.length; i++) {
                if(flights[i][0] == src && flights[i][1] == dst){
                    return flights[i][2];
                }
            }
        }
        int price = Integer.MAX_VALUE;
        for (int i = 0; i < flights.length; i++) {
            if(flights[i][0] == src){
                price = Math.min(price, findCheapestPrice(n,flights,flights[i][1], dst, k - 1) + flights[i][2]);
            }
        }
        return price == Integer.MAX_VALUE ? -1 : price;
    }

    public int answer(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[n][K+2];
        for(int i = 0; i < n; ++i) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int k = 0; k <= K+1; ++k) dp[src][k] = 0;
        for(int k = 1; k <= K+1; ++k) {
            for(int[] flight : flights) {
                if(dp[flight[0]][k-1] != Integer.MAX_VALUE)
                    dp[flight[1]][k] = Math.min(dp[flight[1]][k], dp[flight[0]][k-1] + flight[2]);
            }
        }
        return dp[dst][K+1] == Integer.MAX_VALUE ? -1 : dp[dst][K+1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCheapestPrice(5,new int[][]{{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}},2,1,1));
    }
}
