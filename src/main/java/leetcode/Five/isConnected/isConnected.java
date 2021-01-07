package leetcode.Five.isConnected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/7 下午4:40
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class isConnected {
    /**
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     * [1,1,0]
     * [1,1,0]
     * [0,0,1]
     * @param isConnected
     * @return
     */
    public static int findCircleNum(int[][] isConnected) {
        /**
         使用一个visited数组, 依次判断每个节点, 如果其未访问, 朋友圈数加1并对该节点进行dfs搜索标记所有访问到的节点
         **/
        boolean[] visited = new boolean[isConnected.length];
        int ret = 0;
        for(int i = 0; i < isConnected.length; ++i) {
            if(!visited[i]) {
                dfs(isConnected, visited, i);
                ret++;
            }
        }
        return ret;
    }

    private static void dfs(int[][] m, boolean[] visited, int i) {
        for(int j = 0; j < m.length; ++j) {
            if(m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(m, visited, j);
            }
        }
    }


    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        /**
         * [1,1,0,0,0]
         * [1,1,0,0,0]
         * [0,0,1,1,1]
         * [0,0,1,1,1]
         * [0,0,1,1,1]
         */
        int[][] isConnected2 = new int[][]{{1,0,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(findCircleNum(isConnected2));
    }
}
