package leetcode.One.Thousand.kthLargestValue;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/19 下午3:39
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        // 一维矩阵
        if(matrix.length == 0){
            if(k > matrix[0].length){
                return -1;
            } else {
                Arrays.sort(matrix[0]);
                return matrix[0][k-1];
            }
        }
        int[][] xorMatrix = new int[matrix.length][matrix[0].length];
        xorMatrix[0][0] = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i > 0 && j > 0){
                    xorMatrix[i][j] = xorMatrix[i - 1][j - 1];
                    for (int l = 0; l < matrix[i].length; l++) {
                        xorMatrix[i][j] ^= matrix[i][l];
                    }
                    for (int l = 0; l < matrix.length - 1; l++) {
                        xorMatrix[i][j] ^= matrix[l][j];
                    }
                } else {
                    if(i == 0 && j > 0){
                        xorMatrix[i][j] = xorMatrix[i][j - 1] ^ matrix[i][j];
                    }
                    if(i > 0 && j == 0){
                        xorMatrix[i][j] = xorMatrix[i - 1][j] ^ matrix[i][j];
                    }
                }
            }
        }
        int[] result = new int[xorMatrix.length * xorMatrix[0].length];
        int count = 0;
        for (int i = 0; i < xorMatrix.length; i++) {
            for (int j = 0; j < xorMatrix[i].length; j++) {
                result[count++] = xorMatrix[i][j];
            }
        }
        Arrays.sort(result);
        return result[result.length - k];
    }

    public int kthLargestValueV2(int[][] matrix, int k) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length+1];
        int m = matrix.length, n = matrix[0].length;
        int[] pq = new int[m*n];
        int l = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = matrix[i - 1][j - 1] ^ dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i-1][j-1];
                pq[l++] = dp[i][j];
            }
        }
        Arrays.sort(pq);
        return pq[pq.length - k];
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5,2},{1,6}};
        Solution solution = new Solution();
        System.out.println(solution.kthLargestValue(matrix,1));
    }
}
