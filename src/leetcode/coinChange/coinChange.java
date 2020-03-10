package leetcode.coinChange;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-08 18:12
 * @desc:给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * @ex:
 * 输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
* 输入: coins = [2], amount = 3
输出: -1
 *
 */
public class coinChange {
    public static void main(String[] args){
        int coins[] = new int[]{1,2,5};
        int coins2[] = new int[]{2};
        int coins3[] = new int[]{186,419,83,408};
        int amount = 11;
//        System.out.println(coinChange(coins,amount));
//        System.out.println(coinChange(coins2,amount));
        System.out.println(coinChange(coins3,6249));
    }

    public static int coinChange(int[] coins, int amount){
        List list = Collections.singletonList(coins);
        int min = amount;
        if(list.contains(amount)){
            return 1;
        } else {
            for(int i = 0; i < coins.length;i ++){
                min = Math.min(coinChange(coins,amount - coins[i]),min);
            }
            return min + 1;
        }
    }
}
