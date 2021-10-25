package leetcode.Zero.uniquePaths;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-09 17:18
 * @desc 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 *
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class uniquePaths {
    public static int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        if(m <= 1 && n <= 1){
            return 1;
        }
        if(m == 1 && n == 2){
            return 1;
        }
        if(m == 2 && n == 1){
            return 1;
        }
        if(m == 2 && n == 2){
            return 2;
        }
        return uniquePaths(m - 1,n) + uniquePaths(m,n-1);
    }

    public static int uniquePathsV2(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n;j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
        System.out.println(uniquePathsV2(3,7));
    }
}
