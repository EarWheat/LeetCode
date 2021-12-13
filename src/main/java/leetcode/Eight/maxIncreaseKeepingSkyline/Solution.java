package leetcode.Eight.maxIncreaseKeepingSkyline;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/12/13 5:11 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/13 5:11 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] cellMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                colMax[j] = Math.max(colMax[j],grid[i][j]);
                cellMax[i] = Math.max(cellMax[i], grid[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result += Math.min(cellMax[i], colMax[j]) - grid[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
    }
}
