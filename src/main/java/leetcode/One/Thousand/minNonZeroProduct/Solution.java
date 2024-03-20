package leetcode.One.Thousand.minNonZeroProduct;

/**
 * @Desc:1969. 数组元素的最小非零乘积
 * @Author: 泽露
 * @Date: 2024/3/20 11:39 AM
 * @Version: 1.initial version; 2024/3/20 11:39 AM
 */
public class Solution {
    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        long mod = 1000000007;
        long x = fastPow(2, p, mod) - 1;
        long y = (long) 1 << (p - 1);
        return (int) (fastPow(x - 1, y - 1, mod) * x % mod);
    }

    public long fastPow(long x, long n, long mod) {
        long res = 1;
        for (; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
        }
        return res;
    }
}