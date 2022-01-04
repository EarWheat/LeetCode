package leetcode.Zero.uniquePathsWithObstacles;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：63. 不同路径 II
 * @prd : https://leetcode-cn.com/problems/unique-paths-ii/
 * @date ：2022/1/4 2:52 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/4 2:52 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
//        if(obstacleGrid.length == 1){
//            for (int i = 0; i < obstacleGrid[0].length; i++) {
//                if(obstacleGrid[0][i] == 1){
//                    return 0;
//                }
//            }
//            return 1;
//        }
//        int result = 0;
//        // 右移动
//        if(obstacleGrid[0].length > 1 && obstacleGrid[0][1] == 0){
//            result += uniquePathsWithObstacles(arrayCopy(obstacleGrid,0));
//        }
//        // 下移动
//        if(obstacleGrid[1][0] == 0){
//            result += uniquePathsWithObstacles(arrayCopy(obstacleGrid,1));
//        }
//        return result;
    }

    // to: 0 右移动 1 下移动
    public int[][] arrayCopy(int[][] array, int to){
        if(array.length == 0){
            return array;
        }
        int[][] newArray;
        if(to == 0){
            newArray = new int[array.length][array[0].length - 1];
            for (int i = 0; i < array.length; i++) {
                for (int j = 1; j < array[0].length; j++) {
                    newArray[i][j - 1] = array[i][j];
                }
            }
        } else {
            newArray = new int[array.length - 1][array[0].length];
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    newArray[i - 1][j] = array[i][j];
                }
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(solution.uniquePathsWithObstacles(array));
    }
}
