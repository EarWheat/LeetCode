package leetcode.Seven.isToeplitzMatrix;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/22 下午2:28
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length == 0){
            return false;
        }
        if(matrix.length == 1){
            return true;
        }
        if(matrix[0].length == 1){
            return true;
        }
        // 行遍历
        for (int i = 0; i < matrix[0].length; i++) {
            int m = 0;
            int n = i;
            if(!isToeplitzCell(matrix,m,n)){
                return false;
            }
        }
        // 列遍历
        for (int i = 1; i < matrix.length; i++) {
            int m = i;
            int n = 0;
            if(!isToeplitzCell(matrix,m,n)){
                return false;
            }
        }
        return true;
    }

    // 判断第m行，第i列起是否满足托普利茨
    public boolean isToeplitzCell(int[][] matrix, int m, int n){
        int temp = matrix[m][n];
        m++;
        n++;
        while (m < matrix.length && n < matrix[0].length){
            if(matrix[m][n] != temp){
                return false;
            }
            m++;
            n++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{97,97},{80,97},{10,80}};
        Solution solution = new Solution();
        System.out.println(solution.isToeplitzMatrix(matrix));
    }
}
