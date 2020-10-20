package leetcode.History.integerBreak;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-30 09:40
 * @desc:
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

示例 1:

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。


思路：
* 暴力贪心求解：
* 先求拆分为2数之和，再拆分3数之和，再4，5，6.....
 */
public class integerBreak {
    public static int integerBreak(int n) {
        if(n <= 2){
            return 1;
        }
        int max = 0;
        for(int i = 2; i < n; i++){
            // 求解i数之和
            int temp = multiResult(n,i);
            if(temp > max){
                max = temp;
            } else {
                break;
            }
        }
        return max;
    }

    // 将n拆分为m个数之和，并求积
    private static int multiResult(int n, int m){
        int multi = n / m;
        int result = 1;
        if(n % m == 0){
            // 刚好能平均分
            for(int i = 0; i < m; i++){
                result = result * multi;
            }
            return result;
        } else {
            // 如果不能平均拆分则会出现差值
            int temp = n % m;   // 余数
            for(int i = 0; i < m - temp; i++){
                result = result * multi;
            }
            for(int i = m - temp; i < m; i++){
                result = result * (multi + 1);
            }
            return result;
        }
    }


    public static void main(String[] args) {
        System.out.println(integerBreak(10));
        System.out.println(integerBreak(20));
    }
}
