package leetcode.Zero.numWays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/1 下午7:02
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int numWays(int n, int[][] relation, int k) {
        boolean[][] neighbours = new boolean[n][n];
        for (int[] aRelation : relation) {
            neighbours[aRelation[0]][aRelation[1]] = true;
        }
        return dfs(0, neighbours, k);
    }

    private int dfs(int player, boolean[][] neighbours, int k) {
        if (k == 0) {
            // 经过k轮
            return neighbours.length - 1 == player ? 1 : 0;
        }
        int curResult = 0;
        for (int i = 0; i < neighbours[player].length; i++) {
            if (neighbours[player][i]) {
                curResult += dfs(i, neighbours, k - 1);
            }
        }
        return curResult;
    }
}
