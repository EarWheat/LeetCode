package leetcode.One.maxProfit;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-08 12:55
 * @desc 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
     * dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);      // 1、昨天持有，今天仍持有。2、昨天未持有，今天购入
     */
    public static int maxProfit(int k, int[] prices) {
        if(k < 1) return 0;
        if(k >= prices.length/2) return greedy(prices);
        int[][] t = new int[k][2];
        for(int i = 0; i < k; ++i)
            t[i][0] = Integer.MIN_VALUE;
        for(int p : prices) {
            t[0][0] = Math.max(t[0][0], -p);
            t[0][1] = Math.max(t[0][1], t[0][0] + p);
            for(int i = 1; i < k; ++i) {
                t[i][0] = Math.max(t[i][0], t[i-1][1] - p);
                t[i][1] = Math.max(t[i][1], t[i][0] + p);
            }
        }
        return t[k-1][1];
    }

    private static int greedy(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] > prices[i-1])
                max += prices[i] - prices[i-1];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2,new int[]{3,2,6,5,0,3}));
//        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
