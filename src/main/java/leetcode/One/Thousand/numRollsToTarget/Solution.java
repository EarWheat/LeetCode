package leetcode.One.Thousand.numRollsToTarget;

import java.util.Calendar;
import java.util.Date;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/10/24 3:51 PM
 * @Version: 1.initial version; 2023/10/24 3:51 PM
 */
public class Solution {
    static final int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= target; ++j) {
                for (int x = 1; x <= k; ++x) {
                    if (j - x >= 0) {
                        f[i][j] = (f[i][j] + f[i - 1][j - x]) % MOD;
                    }
                }
            }
        }
        return f[n][target];
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 17);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTimeInMillis());
    }
}
