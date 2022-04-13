package Interview.findNumberIn2DArray;

/**
 * @author ：liuzhaolu
 * @description：剑指 Offer 04. 二维数组中的查找
 * @prd : https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @date ：2022/4/13 10:55 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/13 10:55 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        return find(matrix, target, matrix.length - 1, 0);
    }

    public boolean findNumberIn2DArrayV2(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (target > matrix[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

    public boolean find(int[][] matrix, int target, int i, int j) {
        if (i < 0 || j >= matrix[0].length) {
            return false;
        }
        if (target == matrix[i][j]) {
            return true;
        }
        if (target > matrix[i][j]) {
            return find(matrix, target, i, j + 1);
        } else {
            return find(matrix, target, i - 1, j);
        }
    }
}
