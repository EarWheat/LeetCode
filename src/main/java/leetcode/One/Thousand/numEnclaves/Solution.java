package leetcode.One.Thousand.numEnclaves;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author ：liuzhaolu
 * @description：1020. 飞地的数量
 * @prd : https://leetcode-cn.com/problems/number-of-enclaves/
 * @date ：2022/2/12 3:23 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/12 3:23 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            dfs(visited, grid, 0, i);
            dfs(visited, grid, grid.length - 1, i);
        }
        for (int i = 1; i < grid.length - 1; i++) {
            dfs(visited, grid, i, 0);
            dfs(visited, grid, i, grid[0].length - 1);
        }
        int resp = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                resp += (!visited[i][j] && grid[i][j] == 1) ? 1 : 0;
            }
        }
        return resp;
    }


    public void dfs(boolean[][] visited, int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        // 上
        dfs(visited, grid, i - 1, j);
        // 下
        dfs(visited, grid, i + 1, j);
        // 左
        dfs(visited, grid, i, j - 1);
        // 右
        dfs(visited, grid, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        Solution solution = new Solution();
        System.out.println(solution.numEnclaves(grid));
    }
}
