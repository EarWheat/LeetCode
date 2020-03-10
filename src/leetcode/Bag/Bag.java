package leetcode.Bag;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-10 17:54
 * @desc:01背包问题
 */
public class Bag {
    public static void main(String[] args){
        int[] weight = new int[]{ 0 , 2 , 3 , 4 , 5 };			//商品的体积2、3、4、5
        int[] value  = new int[]{ 0 , 3 , 4 , 5 , 6 };			//商品的价值3、4、5、6
        int bagV = 8;					        //背包大小

    }

    private static int maxValue(int[] weight, int[] value, int bagV){
        int[][] dp = new int[weight.length][bagV+1];    // 动态规划表
        for (int i = 1; i <= weight.length;i++){
            for(int j = 1; j <= bagV; j++){      //  背包容积
                if(j < weight[j]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[weight.length - 1][bagV+1];
    }

}
