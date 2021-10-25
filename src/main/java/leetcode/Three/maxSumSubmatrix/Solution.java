package leetcode.Three.maxSumSubmatrix;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/22 下午3:59
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max += matrix[i][j];
            }
        }
        return subMatrix(matrix,max,k,0,0,matrix.length - 1, matrix[0].length - 1);
    }

    // <i1,j1>为左上角坐标，<i2,j2>为右下角坐标
    public int subMatrix(int[][] matrix, int max, int k, int i1, int j1, int i2, int j2){
        if(max<=k){
            return max;
        }
        if(i1 == i2){   // 在同一行上
            // 找出行最大值
        }
        if(j1 == j2){
            // 找出列最大值
        }
        if(i1 >= matrix.length || j1 >= matrix[0].length || i2 < 0 || j2 < 0){
            return 0;
        }
        int topValue = lineValue(matrix,i1,j1,j2);
        int bottomValue = lineValue(matrix,i2,j1,j2);
        int leftValue = cellValue(matrix,j1,i1,i2);
        int rightValue = cellValue(matrix,j2,i1,i2);
        // 删除最小的行
        int minValue = Integer.MAX_VALUE;
        if(topValue > 0){
            minValue = Math.min(minValue,topValue);
        }
        if(bottomValue > 0){
            minValue = Math.min(minValue,bottomValue);
        }
        if(leftValue > 0){
            minValue = Math.min(minValue,leftValue);
        }
        if(rightValue > 0){
            minValue = Math.min(minValue, rightValue);
        }
        int temp = Integer.MIN_VALUE;
        if(topValue == minValue){
            temp = Math.max(temp, subMatrix(matrix, max - topValue,k,i1 +1,j1,i2,j2));
        }
        if(bottomValue == minValue){
            temp = Math.max(temp, subMatrix(matrix, max - bottomValue,k,i1,j1,i2 - 1,j2));
        }
        if(leftValue == minValue){
            temp = Math.max(temp, subMatrix(matrix, max - leftValue,k,i1,j1 + 1, i2 ,j2));
        }
        if(rightValue == minValue){
            temp = Math.max(temp, subMatrix(matrix, max - rightValue,k,i1,j1,i2,j2 - 1));
        }
        return temp;
    }

    // 行的值
    public int lineValue(int[][] matrix, int line, int i, int j){
        int value = 0;
        for (int index = i; index <= j; index++) {
            value += matrix[line][index];
        }
        return value;
    }

    // 列的值
    public int cellValue(int[][] matrix, int cell, int i, int j){
        int value = 0;
        for (int index = i; index <= j; index++) {
            value += matrix[index][cell];
        }
        return value;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,2,-1}};
        Solution solution = new Solution();
        System.out.println(solution.maxSumSubmatrix(matrix,0));
    }
}
