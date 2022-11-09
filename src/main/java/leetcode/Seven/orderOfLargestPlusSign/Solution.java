package leetcode.Seven.orderOfLargestPlusSign;
//在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示
//grid[xi][yi] == 0
//
// 返回 grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
//
// 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，
//由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
//
//
//
// 示例 1：
//
//
//
//
//输入: n = 5, mines = [[4, 2]]
//输出: 2
//解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
//
//
// 示例 2：
//
//
//
//
//输入: n = 1, mines = [[0, 0]]
//输出: 0
//解释: 没有加号标志，返回 0 。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 500
// 1 <= mines.length <= 5000
// 0 <= xi, yi < n
// 每一对 (xi, yi) 都 不重复
//
// Related Topics 数组 动态规划 👍 158 👎 0

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/11/9 3:04 PM
 * @Version: 1.initial version; 2022/11/9 3:04 PM
 */
public class Solution {

    int[][] grid = null;

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        Set<Integer> banned = new HashSet<Integer>();
        for (int[] vec : mines) {
            banned.add(vec[0] * n + vec[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* left */
            for (int j = 0; j < n; j++) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            /* right */
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* up */
            for (int j = 0; j < n; j++) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
            count = 0;
            /* down */
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }

    public void buildGrid(int n, int[][] mines) {
        int[][] gridBuild = new int[n][n];
        Arrays.fill(gridBuild, 1);
        for (int i = 0; i < mines.length; i++) {
            int[] temp = mines[0];
            gridBuild[temp[0]][temp[1]] = 0;
        }
        this.grid = gridBuild;
    }

//    public void dfs(int i, int j, int length) {
//        if (grid[i][j] == 0) {
//            return;
//        }
//        if (i >= 1 && grid[i - 1][j] == 1
//                ||)
//    }
}
