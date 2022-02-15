package leetcode.One.Thousand.luckyNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：1380. 矩阵中的幸运数
 * @prd : https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 * @date ：2022/2/15 3:58 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/15 3:58 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rows = new int[row];
        int[] cols = new int[col];
        Arrays.fill(rows, Integer.MAX_VALUE);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = matrix[i][j];
                rows[i] = Math.min(cur, rows[i]);
                cols[j] = Math.max(cur, cols[j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = matrix[i][j];
                if (cur == rows[i] && cur == cols[j]) {
                    res.add(cur);
                }
            }
        }
        return res;

    }
}
