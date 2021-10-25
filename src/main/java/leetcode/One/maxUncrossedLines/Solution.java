package leetcode.One.maxUncrossedLines;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/21 下午3:51
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= n; j++) {
                int num2 = nums2[j - 1];
                if (num1 == num2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }




    public int findIndexByNum(int[] nums, int index, int target){
        while (index < nums.length){
            if(nums[index] == target){
                return index;
            }
            index++;
        }
        return -1;
    }
}
