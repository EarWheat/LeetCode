package leetcode.Two.searchMatrix;

/**
 * @author ：liuzhaolu
 * @date ：2021/10/25 5:22 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/10/25      liuzhaolu       firstVersion
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j >=0){
            if(j == matrix[i].length){
                return false;
            }
            int temp = matrix[i][j];
            if(target == temp){
                return true;
            }
            if(target > temp){
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-1,3}};
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix,3));
    }
}
