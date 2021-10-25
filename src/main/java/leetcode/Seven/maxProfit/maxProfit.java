package leetcode.Seven.maxProfit;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-17 20:29
 * @desc 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class maxProfit {
    /**
     *  * 输入: [7,1,5,3,6,4]
     *  * 输出: 7
     *  * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *  *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     */
    /**
     * 动态规划，
     * dp[i][0] 表示第i天未持有股票的最大利润（包括不购入，或者卖出股票）
     * dp[i][1] 表示第i天持有股票的利润（包括购入）
     * 转移方程:
     * dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1])      // 1、分为今天仍不购买，且昨天未持有股票。2、昨天持有股票，卖出
     * dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);      // 1、昨天持有，今天仍持有。2、昨天未持有，今天购入
     */
    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for(int i = 1; i < prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,3,2,8,4,9};
        System.out.println(maxProfit(prices,2));
    }
}
