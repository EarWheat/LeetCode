package leetcode.Zero.rotate;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-19 15:17
 * @desc 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class rotate {
    public static void rotate(int[][] matrix) {
        /**
         *  * 给定 matrix =
         *  * [
         *  *   [ 5, 1, 9,11],
         *  *   [ 2, 4, 8,10],
         *  *   [13, 3, 6, 7],
         *  *   [15,14,12,16]
         *  * ],
         *  *
         *  * 原地旋转输入矩阵，使其变为:
         *  * [
         *  *   [15,13, 2, 5],
         *  *   [14, 3, 4, 1],
         *  *   [12, 6, 8, 9],
         *  *   [16, 7,10,11]
         *  * ]
         *  // 每次旋转涉及最外层数字
         */
        int level = matrix.length;
        for(int i = 0; i < level; i++){
            switchMatrix(i,level,matrix);
            level = level / 2;
        }
    }

    public static void switchMatrix(int i, int length, int[][] matrix){
        int n = length;
        for(int j = i; j < n - 1;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[n - 1 - j][i];
            matrix[n - 1 - j][i] = matrix[n - 1][n - 1 - j];
            matrix[n - 1][n - 1 - j] = matrix[i + j][n - 1];
            matrix[i + j][n - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        rotate(matrix);
        System.out.println(JSONObject.toJSONString(matrix));
    }
}
