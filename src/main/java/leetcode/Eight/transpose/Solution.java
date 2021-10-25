package leetcode.Eight.transpose;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/25 下午2:17
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] response = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < response.length; i++) {
            for (int j = 0; j < response[i].length; j++) {
                response[i][j] = matrix[j][i];
            }
        }
        return response;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Solution solution = new Solution();
        solution.transpose(matrix);
    }
}
