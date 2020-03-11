package leetcode.Bag;

import UtilClass.ShowArray;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-10 17:54
 * @desc:01背包问题
 */
public class Bag extends ShowArray{
    public static void main(String[] args){
        int[] weight = new int[]{ 2 , 3 , 4 , 5 };			//商品的体积2、3、4、5
        int[] value  = new int[]{ 3 , 4 , 5 , 6 };			//商品的价值3、4、5、6
        int bagV = 8;					        //背包大小
        int result = maxValue(weight,value,bagV);
    }

    private static int maxValue(int[] weight, int[] value, int bagV){
        int[][] dp = new int[weight.length][bagV];    // 动态规划表
        for (int i = 0; i < weight.length; i++){
            for(int j = 1; j <= bagV; j++){      //  背包容积
                if(j < weight[i]){
                    if(i == 0){
                        dp[0][j] = 0;
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                } else {
                    if(i == 0){
                        dp[0][j] = value[i];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                    }
                }
            }
        }
//        ShowArray(dp);
        return dp[weight.length - 1][bagV+1];
    }

}
