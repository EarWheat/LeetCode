package leetcode.Four.findDiagonalOrder;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/14 12:21 PM
 * @Version: 1.initial version; 2022/6/14 12:21 PM
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length * mat[0].length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (index < result.length) {
            while (i >= 0 && j >= 0) {
                if(i < mat.length && j < mat[0].length){
                    result[index++] = mat[i][j];
                }
                if(i - 1 < 0){
                    j++;
                    break;
                }
                i--;
                j++;
            }
            while (i >= 0 && j >= 0) {
                if(i < mat.length && j < mat[0].length){
                    result[index++] = mat[i][j];
                }
                if(j - 1 < 0){
                    i++;
                    break;
                }
                i++;
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // [1,2,4,7,5,3,6,8,9]
        System.out.println(Arrays.toString(solution.findDiagonalOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})));
    }
}
