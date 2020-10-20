package leetcode.History.longestIncreasingPath;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-26 08:35
 * @desc:
 * 给定一个整数矩阵，找出最长递增路径的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

示例 1:

输入: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
输出: 4
解释: 最长递增路径为 [1, 2, 6, 9]。
示例 2:

输入: nums =
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
输出: 4
解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。

* 思路：动态规划
* dp[i][j] 表示[i,j]位置的最长递增
* 1、因为没规定起点，所以任意位置都可作为初始点
* 2、对于[i,j]点，可能来自上、下、左、右四个方向。
* 3、所以动态转化的方程为(i,j均大于1)
* if(上<中)
* dp[i][j] = Math.max(dp[i - 1][j] +
*                         上     < 中
* 难点：如何确定动态规划开始的起点？以及规划路线？
* 换一种思路：贪心算法
* 从当前数组里面最小的点出发，每一次找寻4个方向中比该点大但是是最小的方向移动。
* [9,8,3]
* [6,7,8]
* [3,2,3]
* 难点：对于两个相同的选择，该如何抉择？2开始，向左还是向右？
 */
public class longestIncreasingPath {
//    public int longestIncreasingPath(int[][] matrix) {
//        if(matrix.length == 0){
//            return 0;
//        }
//    }
//
//    // 求以i,j为起点的最大递增长度。
//    public static int increasePath(int[][] matrix, int i, int j){
//        int right,left,up, below;
//        // 往上走
//        if(i >= 1){ // 大于1层才能往上
//            if(matrix[i][j] < matrix[i - 1][j]){
//                up = increasePath(matrix,i-1,j) + 1;
//            }
//        }
//        // 往下走
//        if(i < matrix.length - 1){
//            if(matrix[i][j] < matrix[i + 1][j]){
//                below = increasePath(matrix,i+1,j);
//            }
//        }
//        // 往左走
//        if()
//    }




//    public int longestIncreasingPath(int[][] matrix) {
//        if(matrix.length == 0){
//            return 0;
//        }
//        // 动态规划方程
//        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
//        for(int i = 1; i <= matrix.length;i++){
//            for (int j = i; j <= matrix[0].length; j++){
//                int right,left,up, below;
//                // 来自上面，且中心点小于上面
//                up = matrix[i  - 1][j] < matrix[i][j] ? dp[i - 1][j] + 1 : 0;
//                // 来自左边
//                left = matrix[i][j - 1] < matrix[i][j] ? dp[i][j - 1] + 1 : 0;
//                // 来自右边
//                right = matrix[i][j + 1] < matrix[i][j] ? dp[i][j + 1] + 1 : 0;
//                // 来自下面
//                below = matrix[i + 1][j] < matrix[i][j] ? dp[i + 1][j] + 1 : 0;
//                dp[i][j] = Math.max(Math.max(Math.max(up,below),right),left);
//            }
//        }
//        // TODO:难点，如何确定动态规划开始的起点？以及规划路线？
//
//    }
}
