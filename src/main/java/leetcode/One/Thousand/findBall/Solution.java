package leetcode.One.Thousand.findBall;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：1706. 球会落何处
 * @prd : https://leetcode-cn.com/problems/where-will-the-ball-fall/
 * @date ：2022/2/24 3:21 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/24 3:21 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int[] findBall(int[][] grid) {
        if (grid.length < 1) {
            return null;
        }
        int[] answer = new int[grid[0].length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = i;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (answer[j] != -1) {
                    // 滚出左边界
                    if (answer[j] == 0 && grid[i][answer[j]] == -1) {
                        answer[j] = -1;
                    }
                    // 滚出右边界
                    if (answer[j] == grid[i].length - 1 && grid[i][answer[j]] == 1) {
                        answer[j] = -1;
                    }
                    // 卡住
                    if (answer[j] + 1 < grid[i].length && answer[j] >= 0 && grid[i][answer[j]] == 1 && grid[i][answer[j] + 1] == -1) {
                        answer[j] = -1;
                    }
                    if (answer[j] > 0 && grid[i][answer[j]] == -1 && grid[i][answer[j] - 1] == 1) {
                        answer[j] = -1;
                    }
                }
                if (answer[j] != -1) {
                    answer[j] += grid[i][answer[j]];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        System.out.println(Arrays.toString(solution.findBall(grid)));
    }
}
