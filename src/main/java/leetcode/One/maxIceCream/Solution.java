package leetcode.One.maxIceCream;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/2 下午2:24
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            int cost = costs[i];
            if (coins >= cost) {
                coins -= cost;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
