package leetcode.Zero.searchMatrix;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/30 上午7:40
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 1){
            int j = 0;
            while (j < matrix[0].length && target >= matrix[0][j]){
                if(target == matrix[0][j]){
                    return true;
                }
                j++;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if(target == matrix[i][0]){
                return true;
            }
            if(target < matrix[i][0]){  // 前一行
                if(target < matrix[i - 1][0]){
                    return false;
                }
                int j = 0;
                while (j < matrix[i-1].length && target >= matrix[i - 1][j]){
                    if(target == matrix[i - 1][j]){
                        return true;
                    }
                    j++;
                }
            }
        }
        int j = 0;
        while (j < matrix[matrix.length - 1].length && target >= matrix[matrix.length - 1][j]){
            if(target == matrix[matrix.length - 1][j]){
                return true;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix,30));
    }
}
