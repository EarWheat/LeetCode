package leetcode.findLength;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-01 09:58
 * @desc:
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

示例 1:

输入:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出: 3
解释:
长度最长的公共子数组是 [3, 2, 1]。

 */
public class findLength {
    public static int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,0,0,0,1};
        int[] B = new int[]{1,0,0,0,0};
        System.out.println(findLength(A,B));

        int[] A1 = new int[]{1,2,3,2,1};
        int[] B1 = new int[]{3,2,1,4,7};
        System.out.println(findLength(A1, B1));
    }
}
