package leetcode.Eight.matrixScore;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-07 20:19
 * @desc 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class matrixScore {
    // 一定可以保证第一列全是1，后续变换列，保证1最多

    /**
     * [0,0,1,1]            [1,1,0,0]            [1,1,1,0]       [1,1,1,1]
     * [1,0,1,0]            [1,0,1,0]            [1,0,0,0]       [1,0,0,1]
     * [1,1,0,0]            [1,1,0,0]            [1,1,1,0]       [1,1,1,1]
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        if(A.length <= 0){
            return 0;
        }
        // 保证第一列全是1
        for(int i = 0; i < A.length; i++){
            if(A[i][0] != 1){
                line(i,A);
            }
        }
        // 保证每一列1比0多
        for(int i = 0; i < A[0].length; i++){

        }
        return 1;
    }

    // 行转换
    public void line(int i, int[][] A){
        int length = A[i].length;
        for(int m = 0; m < length; m++){
            if(A[i][m] == 1){
                A[i][m] = 0;
            } else {
                A[i][m] = 1;
            }
        }
    }

    // 列转换
    public void cell(int i, int[][] A){
        int length = A.length;
        for(int m = 0; m < length; m++){
            if(A[m][i] == 1){
                A[m][i] = 0;
            } else {
                A[m][i] = 1;
            }
        }
    }

    public int matrixScoreV2(int[][] A) {
        int res = 0;
        int m = A.length;
        int n = A[0].length;
        // 1. 进行行翻转，可以将第一列全部翻转成 1
        res += m * (1 << (n - 1));
        // 2. 接下对每一列进行分析，让每一列的 1 最多
        for (int j = 1; j < n; j++) {
            int count1 = 0;
            for (int i = 0; i < m; i++) {
                count1 += A[i][0] == 1 ? A[i][j] : 1 - A[i][j];
            }
            res += Math.max(count1, m - count1) * (1 << (n - 1 - j));

        }
        return res;
    }
}
