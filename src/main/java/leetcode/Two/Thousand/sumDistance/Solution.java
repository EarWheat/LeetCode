package leetcode.Two.Thousand.sumDistance;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/10/10 4:21 PM
 * @Version: 1.initial version; 2023/10/10 4:21 PM
 */
public class Solution {
    static final int MOD = 1000000007;

    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                pos[i] = (long) nums[i] - d;
            } else {
                pos[i] = (long) nums[i] + d;
            }
        }
        Arrays.sort(pos);
        long res = 0;
        for (int i = 1; i < n; i++) {
            res += 1L * (pos[i] - pos[i - 1]) * i % MOD * (n - i) % MOD;
            res %= MOD;
        }
        return (int) res;
    }
}
