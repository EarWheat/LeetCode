package leetcode.Two.construct2DArray;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/1/1 3:53 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/1 3:53 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m * n){
            return new int[0][0];
        }
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[i * n + j];
            }
        }
        return result;
    }
}
