package leetcode.Three.countNumbersWithUniqueDigits;

/**
 * @author ：liuzhaolu
 * @description：357. 统计各位数字都不同的数字个数
 * @prd : https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 * @date ：2022/4/11 11:28 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/11 11:28 上午     liuzhaolu       firstVersion
 */
public class Solution {
    /**
     * 考虑首位不为0，第一位能选 1~9，9个，第二位能选 0~9 中处了第一位以外的 9 个，第三位 8 个。。以此类推
     *
     * 考虑首位为 0，相当于 n-1 的情况，在前面已经计算过了
     *
     * 所以最终结果就是两者相加
     *
     * n = 0 ：1
     *
     * n = 1 ：9 + 1
     *
     * n = 2 ：9*9 + 10
     *
     * n = 3 ：9*9*8 + 91
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        int product = 9;
        for (int i = 1; i < 10 && i <= n; i++) {
            res = product + res;
            product *= (10-i);
        }
        return res;
    }
}
