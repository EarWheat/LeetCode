package leetcode.One.Thousand.finalPrices;

/**
 * @Desc: 商品折扣后的最终价格
 * @Author: 泽露
 * @Date: 2022/9/1 4:22 PM
 * @Version: 1.initial version; 2022/9/1 4:22 PM
 */
public class Solution {
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if(prices[j] <= prices[i]){
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
