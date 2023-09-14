package leetcode.Two.Thousand.checkValidGrid;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/9/13 8:35 PM
 * @Version: 1.initial version; 2023/9/13 8:35 PM
 */
public class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int[][] indices = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                indices[grid[i][j]][0] = i;
                indices[grid[i][j]][1] = j;
            }
        }
        for (int i = 1; i < n * n; i++) {
            int dx = Math.abs(indices[i][0] - indices[i - 1][0]);
            int dy = Math.abs(indices[i][1] - indices[i - 1][1]);
            if (dx * dy != 2) {
                return false;
            }
        }
        return true;
    }
}
