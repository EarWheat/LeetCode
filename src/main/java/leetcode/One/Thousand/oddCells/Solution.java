package leetcode.One.Thousand.oddCells;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/12 11:13 AM
 * @Version: 1.initial version; 2022/7/12 11:13 AM
 */
public class Solution {
    /**
     * 输入：m = 2, n = 3, indices = [[0,1],[1,1]] 输出：6 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。 第一次增量操作后得到 [[1,2,1],[0,1,0]]。 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
     *
     * @param m
     * @param n
     * @param indices
     * @return // i : 0,1     1,1
     * // j : 1,2
     */
    public int oddCells(int m, int n, int[][] indices) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> cellMap = new HashMap<>();
        for (int[] indict : indices) {
            int row = indict[0];
            int cell = indict[1];
            if (rowMap.containsKey(row)) {
                rowMap.put(row, rowMap.get(row) + 1);
            } else {
                rowMap.put(row, 1);
            }
            if (cellMap.containsKey(cell)) {
                cellMap.put(cell, cellMap.get(cell) + 1);
            } else {
                cellMap.put(cell, 1);
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rowMap.getOrDefault(i, 0) + cellMap.getOrDefault(j, 0)) % 2 == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
    }
}
