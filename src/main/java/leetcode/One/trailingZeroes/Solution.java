package leetcode.One.trailingZeroes;

/**
 * @author ：liuzhaolu
 * @description：172. 阶乘后的零
 * @prd : https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * @date ：2022/3/25 2:25 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/25 2:25 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
