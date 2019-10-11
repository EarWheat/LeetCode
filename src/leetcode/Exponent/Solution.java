package leetcode.Exponent;

/*
 * @author:liuzhaolu
 * @createTime: 2019-10-11 19:33
 * @desc:给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0
 */
public class Solution {
    public double Power(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        double result = base;
        for(int i = 0 ; i < Math.abs(exponent) - 1; i++){
            result = result * base;
        }
        if(exponent > 0){
            return result;
        }
        if(exponent < 0){
            return 1/result;
        }
        return 0;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        double base = 2;
        int exponent = -3;
        System.out.println(solution.Power(base,exponent));
    }
}
