package leetcode.Zero.setZeroes;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/21 上午8:09
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[][] transformed = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0 && !transformed[i][j]){
                    transform(i,j,matrix,transformed);
                }
            }
        }
    }

    public void transform(int i, int j, int[][] matrix, boolean[][] transformed){
        transformed[i][j] = true;
        for (int k = 0; k < matrix[i].length; k++) {
            if(matrix[i][k] != 0){
                transformed[i][k] = true;
            }
            matrix[i][k] = 0;
        }
        for (int k = 0; k < matrix.length; k++) {
            if(matrix[k][j] != 0){
                transformed[k][j] = true;
            }
            matrix[k][j] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        Solution solution = new Solution();
        solution.setZeroes(matrix);
        System.out.println(JSONObject.toJSONString(matrix));
    }
}
