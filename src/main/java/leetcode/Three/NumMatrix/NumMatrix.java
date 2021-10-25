package leetcode.Three.NumMatrix;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/2 下午3:41
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class NumMatrix {

    public int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                result += matrix[i][j];
            }
        }
        return result;
    }

}
