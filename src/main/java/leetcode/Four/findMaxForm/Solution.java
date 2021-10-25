package leetcode.Four.findMaxForm;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/6 下午3:26
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
//        int[][] numsOf01 = new int[strs.length][2];
//        for (int i = 0; i < strs.length; i++) {
//            int numsOf0 = 0;
//            int numsOf1 = 0;
//            for (int j = 0; j < strs[i].length(); j++) {
//                if(strs[i].charAt(i) == '0'){
//                    numsOf0++;
//                }
//                if(strs[i].charAt(i) == 1){
//                    numsOf1++;
//                }
//            }
//            numsOf01[i][0] = numsOf0;
//            numsOf01[i][1] = numsOf1;
//        }
//        int[] dp = new int[strs.length];
//        for (int i = 0; i < strs.length; i++) {
//
//        }
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i - 1]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }

}
