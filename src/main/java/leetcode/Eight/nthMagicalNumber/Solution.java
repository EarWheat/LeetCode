package leetcode.Eight.nthMagicalNumber;
//一个正整数如果能被 a 或 b 整除，那么它是神奇的。
//
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10⁹ + 7 取模 后的值。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 1, a = 2, b = 3
//输出：2
//
//
// 示例 2：
//
//
//输入：n = 4, a = 2, b = 3
//输出：6
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁹
// 2 <= a, b <= 4 * 10⁴
//
//
//
// Related Topics 数学 二分查找 👍 168 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/11/22 4:05 PM
 * @Version: 1.initial version; 2022/11/22 4:05 PM
 */
public class Solution {
    static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b);
        long r = (long) n * Math.min(a, b);
        int c = lcm(a, b);
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % MOD);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
