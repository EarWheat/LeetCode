package leetcode.Zero.generateMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/16 上午7:55
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {

    public static int index = 1;

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0;
        int j = 0;
        while (i < n && j < n && matrix[i][j] == 0){
            matrix[i][j] = index++;
            while (dfs(i, j, "right", matrix)){
                j++;
            }
            while (dfs(i, j, "down", matrix)){
                i++;
            }
            while (dfs(i, j, "left", matrix) ){
                j--;
            }
            while (dfs(i, j, "up", matrix)){
                i--;
            }
            j++;
        }
        return matrix;
    }



    public static boolean dfs(int i, int j, String style, int[][] matrix){
        if(style.equals("right")){
            if(j + 1 < matrix[0].length && matrix[i][j + 1] == 0){
                j++;
                matrix[i][j] = index++;
                return true;
            }
        }
        if(style.equals("down")){
            if(i + 1 < matrix.length && matrix[i + 1][j] == 0){
                i++;
                matrix[i][j] = index++;
                return true;
            }
        }
        if(style.equals("left")){
            if(j - 1 >= 0 && matrix[i][j - 1] == 0){
                j--;
                matrix[i][j] = index++;
                return true;
            }
        }
        if(style.equals("up")){
            if(i - 1 >= 0 && matrix[i - 1][j] == 0){
                i--;
                matrix[i][j] = index++;
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(1)));
    }
}
