package leetcode.History.minPathSum;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-23 19:35
 * @desc:
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

*
* 思路：
* 动态规划
 */
public class minPathSum {
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        int temp = 0;
        for(int i = 0; i < grid[0].length;i++){
            temp += grid[0][i];
            dp[0][i] = temp;
        }
        for(int i = 1; i <= grid.length; i++){
            for(int j = 2; j <= grid[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j] + grid[i - 1][j - 1],dp[i][j-1] + grid[i - 1][j - 1]);
            }
        }
        return dp[grid.length][grid[0].length];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
