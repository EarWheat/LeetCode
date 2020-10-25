package leetcode.Eight.longestMountain;

import com.alibaba.fastjson.JSON;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-25 14:31
 * @desc 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 *
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class longestMountain {
    // [2,1,4,7,3,2,5]
    public static int longestMountain(int[] A) {
        if(A.length <= 3){
            return 0;
        }
        // 动态规划，
        // dp[i][0]表示以A[i]作为峰值的左峰长度
        // dp[i][1]表示以A[i]作为峰值的右峰长度
        // dp[i][2]表示以A[i]作为峰值的长度。
        int[][] dp = new int[A.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        // 从前往后可以求左锋;
        for (int i = 1; i < A.length; i++){
            if(A[i] == A[i - 1]){
                dp[i][0] = 0;
                continue;
            }
            if(A[i - 1] < A[i]){
                dp[i][0] = dp[i-1][0] + 1;
            }
        }
        // 从后往前可以求右峰;
        for(int i = A.length - 2;i >= 0;i--){
            if(A[i] == A[i + 1]){
                dp[i][1] = 0;
                continue;
            }
            if(A[i] > A[i + 1]){
                dp[i][1] = dp[i + 1][1] + 1;
            }
        }
        int result = 0;
        for(int i = 0; i < dp.length;i++){
            // 一定有坡度才行
            if(dp[i][0] != 0 && dp[i][1] != 0){
                result = Math.max(result,dp[i][0] + dp[i][1] + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2,1,4,6,7,7,3,2,5}));
        System.out.println(longestMountain(new int[]{2,2,2}));
    }
}
