package leetcode.Zero.minPathSum;

/**
 * @author ：liuzhaolu
 * @description：64. 最小路径和
 * @prd : https://leetcode-cn.com/problems/minimum-path-sum/
 * @date ：2022/1/11 2:35 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/11 2:35 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length < 1){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 第0列
                if(j == 0){
                    if(i > 0){
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    }
                } else if(i == 0){
                    if(j > 0){
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(grid));
    }
}
