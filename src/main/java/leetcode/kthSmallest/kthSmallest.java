package leetcode.kthSmallest;

import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-02 15:55
 * @desc:给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。

 

示例：

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。

思路：
* 找第K小的元素即是找 n * n + 1 - k 大的数。   第2大
* 第k大的数一定在n * n右边
*
 */
public class kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }
}
