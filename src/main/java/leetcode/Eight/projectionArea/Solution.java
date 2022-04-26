package leetcode.Eight.projectionArea;

/**
 * @author ：liuzhaolu
 * @description：883. 三维形体投影面积
 * @prd :https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 * @date ：2022/4/26 10:53 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/26 10:53 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyArea = 0, yzArea = 0, zxArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0, zxHeight = 0;
            for (int j = 0; j < n; j++) {
                xyArea += grid[i][j] > 0 ? 1 : 0;
                yzHeight = Math.max(yzHeight, grid[j][i]);
                zxHeight = Math.max(zxHeight, grid[i][j]);
            }
            yzArea += yzHeight;
            zxArea += zxHeight;
        }
        return xyArea + yzArea + zxArea;
    }
}
