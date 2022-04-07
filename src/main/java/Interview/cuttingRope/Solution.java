package Interview.cuttingRope;

/**
 * @author ：liuzhaolu
 * @description：剑指 Offer 14- I. 剪绳子
 * @prd : https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @date ：2022/4/7 5:37 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/7 5:37 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
}
