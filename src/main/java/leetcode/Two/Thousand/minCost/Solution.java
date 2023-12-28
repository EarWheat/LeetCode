package leetcode.Two.Thousand.minCost;

/**
 * @Desc: 2735. 收集巧克力
 * @Author: 泽露
 * @Date: 2023/12/28 2:58 PM
 * @Version: 1.initial version; 2023/12/28 2:58 PM
 */
public class Solution {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[] f = new int[n];
        System.arraycopy(nums, 0, f, 0, n);
        long ans = getSum(f);
        for (int k = 1; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                f[i] = Math.min(f[i], nums[(i + k) % n]);
            }
            ans = Math.min(ans, (long) k * x + getSum(f));
        }
        return ans;
    }

    public long getSum(int[] f) {
        long sum = 0;
        for (int num : f) {
            sum += num;
        }
        return sum;
    }
}

