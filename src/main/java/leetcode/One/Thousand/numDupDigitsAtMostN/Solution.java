package leetcode.One.Thousand.numDupDigitsAtMostN;
//给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。
//
//
//
// 示例 1：
//
//
//输入：n = 20
//输出：1
//解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
//
//
// 示例 2：
//
//
//输入：n = 100
//输出：10
//解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
//
//
// 示例 3：
//
//
//输入：n = 1000
//输出：262
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁹
//
// Related Topics 数学 动态规划 👍 172 👎 0

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/3/20 11:46 AM
 * @Version: 1.initial version; 2023/3/20 11:46 AM
 */
public class Solution {
    int[][] dp;

    public int numDupDigitsAtMostN(int n) {
        String sn = String.valueOf(n);
        dp = new int[sn.length()][1 << 10];
        for (int i = 0; i < sn.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return n + 1 - f(0, sn, 0, true);
    }

    public int f(int mask, String sn, int i, boolean same) {
        if (i == sn.length()) {
            return 1;
        }
        if (!same && dp[i][mask] >= 0) {
            return dp[i][mask];
        }
        int res = 0, t = same ? (sn.charAt(i) - '0') : 9;
        for (int k = 0; k <= t; k++) {
            if ((mask & (1 << k)) != 0) {
                continue;
            }
            res += f(mask == 0 && k == 0 ? mask : mask | (1 << k), sn, i + 1, same && k == t);
        }
        if (!same) {
            dp[i][mask] = res;
        }
        return res;
    }
}
