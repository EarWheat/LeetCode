package leetcode.Seven.countPrimeSetBits;

/**
 * @author ：liuzhaolu
 * @description：762. 二进制表示中质数个计算置位
 * @prd : https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 * @date ：2022/4/5 4:28 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/5 4:28 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int countPrimeSetBits(int L, int R) {
        boolean[] flag = new boolean[33];
        for (int i = 2; i <= 32; i++) {
            flag[i] = isPrimeNum(i);
        }
        int res = 0;
        for (int i = L; i <= R; i++) {
            int count = Integer.bitCount(i);
            if (flag[count]) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrimeNum(int i) {
        for (int j = i == 2 ? 3 : 2; j <= Math.sqrt(i) + 1; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
