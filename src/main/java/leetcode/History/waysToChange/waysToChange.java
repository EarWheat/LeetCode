package leetcode.History.waysToChange;

import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-24 10:39
 * @desc:硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)

示例1:

 输入: n = 5
 输出：2
 解释: 有两种方式可以凑成总金额:
5=5
5=1+1+1+1+1
示例2:

 输入: n = 10
 输出：4
 解释: 有四种方式可以凑成总金额:
10=10
10=5+5
10=5+1+1+1+1+1
10=1+1+1+1+1+1+1+1+1+1

* 解题：
* 这应该是典型的动态规划问题。
* 动态规划，每次小循环只用一种硬币。

若在一次for循环中处理四种情况(一个for里带四个硬币的处理情况)，每次计算新一项时，由于每次取的硬币是任意的，会出现对于不同的硬币取法，情况重复的现象。 例如：n=15时，res[15] = 1(全1) + res[15 - 5] + res[15 - 10] = 7，但10 + 5和5 + 10是重复的。

每次小循环只用一种硬币可以避免重复，因为每次小循环中选用的硬币是固定的，在没有到对应硬币的循环前，表内记录对应的解必然不包含该硬币。 例如：n=15时，四次：res[15]=0 -> res[15] = 0 -> res[15] = 2 -> res[15] = 6

实际上coins数组升序也不会影响结果。
 */
public class waysToChange {
    public static void main(String[] args) {
        int[] value = new int[]{25,10,5,1};
        System.out.println(waysToChange(18));
        System.out.println(waysToChange(5));
        System.out.println(waysToChange(10));
        System.out.println(waysToChange(15));  // 6
        //15=10+5
        //15=10+1+1+1+1+1
        //15=5+5+5
        //15=5+5+1+1+1+1+1
        //15=5+1+1+1+1+1+1+1+1+1+1
        //15=1+1+1+1+1+1+1+1+1+1+1+1+1+1+1
    }

    public static int waysToChange(int n){
        int[] value = new int[]{25,10,5,1};
        return toChange(n, value) % 1000000007;
    }

    public static int toChange(int n, int[] value) {
        if(value.length == 1){
            return 1;
        }
        int maxValue = value[0];
        int[] newValue = Arrays.copyOfRange(value,1,value.length);
        // 小于最大面值
        if(n <= maxValue){
            for(int i = 0; i < value.length; i++){
                if(n > value[i]){
                    newValue = Arrays.copyOfRange(value,i,value.length);
                    break;
                }
            }
            //1: n = maxValue;
            //2: n = waysToChange(maxValue);
            return toChange(n,newValue) + 1;
        }
        // 先用最大面值计算。
        int numOfMax = n / maxValue;
        // 剩余金额waysToChange
        int remaining = n % maxValue;
        // 无剩余金额
        if(remaining == 0){
            //1: n = maxValue + .... + maxValue + maxValue;  n 个最大值       ---- 1种
            //2: n = maxValue + .... + maxValue + waysToChange(maxValue); // n - 1个最大值 + 1 * 最大值的支付方式   ----- waysToChange(maxValue)种
            //3: n = maxValue + .... + waysToChange(maxValue) + waysToChange(maxValue); // n - 2个最大值 + 2 * 最大值支付方式 ----- 2 * waysToChange(maxValue)种
            return numOfMax * toChange(maxValue, newValue) + 1;
        }
        return numOfMax * toChange(maxValue, newValue) + toChange(remaining, newValue);
    }


    // 标准答案
    public int waysToChangeAnswer(int n) {
        int dp[] = new int[n+1];
        int[] tokens = {1,5,10,25};
        int mod = 1000000007;
        for(int i=0;i<4;i++){
            for(int j=1;j<=n;j++){
                if(tokens[i]==j){               //硬币刚好等于当前面额
                    dp[j] = (dp[j] + 1)%mod;
                }else if(tokens[i]<j){         //硬币小于当前面额
                    dp[j] = (dp[j] + dp[j-tokens[i]])%mod;
                }                               //硬币大于当前面额，dp[j] = dp[j]，省略了
            }
        }
        return dp[n];
    }

}
