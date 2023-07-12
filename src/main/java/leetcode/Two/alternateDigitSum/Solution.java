package leetcode.Two.alternateDigitSum;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/7/12 11:40 AM
 * @Version: 1.initial version; 2023/7/12 11:40 AM
 */
public class Solution {
    public int alternateDigitSum(int n) {
        int res = 0, sign = 1;
        while (n > 0) {
            res += n % 10 * sign;
            sign = -sign;
            n /= 10;
        }
        return -sign * res;
    }
}
