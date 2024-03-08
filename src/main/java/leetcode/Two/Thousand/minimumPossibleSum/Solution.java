package leetcode.Two.Thousand.minimumPossibleSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc: 2834. 找出美丽数组的最小和
 * @Author: 泽露
 * @Date: 2024/3/8 11:35 AM
 * @Version: 1.initial version; 2024/3/8 11:35 AM
 */
public class Solution {
    public int minimumPossibleSum(int n, int target) {
        int[] nums = new int[n];
        int startNum = 1;
        List<Integer> targetList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (targetList.contains(startNum)) {
                startNum++;
            }
            nums[i] = startNum;
            targetList.add(target - startNum);
            startNum++;
        }
        return Arrays.stream(nums).sum();
    }

    public int minimumPossibleSumAn(int n, int target) {
        final int MOD = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            return (int) ((long) (1 + n) * n / 2 % MOD);
        }
        return (int) (((long) (1 + m) * m / 2 +
                ((long) target + target + (n - m) - 1) * (n - m) / 2) % MOD);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumPossibleSum(2, 3));
    }
}
