package leetcode.One.Thousand.restoreArray;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/25 1:35 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        if(adjacentPairs.length == 1){
            return adjacentPairs[0];
        }
        if(adjacentPairs.length == 2){
            int[] result = new int[3];
            if(adjacentPairs[0][0] == adjacentPairs[1][0]){
                result[0] = adjacentPairs[0][1];
                result[1] = adjacentPairs[0][0];
                result[2] = adjacentPairs[1][1];
            } else if(adjacentPairs[0][0] == adjacentPairs[1][1]){
                result[0] = adjacentPairs[0][1];
                result[1] = adjacentPairs[0][0];
                result[2] = adjacentPairs[1][0];
            } else if(adjacentPairs[0][1] == adjacentPairs[1][0]){
                result[0] = adjacentPairs[0][0];
                result[1] = adjacentPairs[0][1];
                result[2] = adjacentPairs[1][1];
            } else if(adjacentPairs[0][1] == adjacentPairs[1][1]){
                result[0] = adjacentPairs[0][0];
                result[1] = adjacentPairs[0][1];
                result[2] = adjacentPairs[1][0];
            }
            return result;
        }
        int[] first = adjacentPairs[0];
        int[] temp = restoreArray(Arrays.copyOfRange(adjacentPairs,1,adjacentPairs.length));
        int[] result = new int[temp.length + 1];
        if(first[0] == temp[0]){
            result[0] = first[1];
            System.arraycopy(temp, 0, result, 1, temp.length);
        } else if(first[0] == temp[temp.length - 1]){
            System.arraycopy(temp, 0, result, 0, temp.length);
            result[temp.length] = first[1];
        } else if(first[1] == temp[0]){
            result[0] = first[0];
            System.arraycopy(temp, 0, result, 1, temp.length);
        } else if(first[1] == temp[temp.length - 1]){
            System.arraycopy(temp, 0, result, 0, temp.length);
            result[temp.length] = first[0];
        }
        return result;
    }

    public int[] answer(int[][] adjacentPairs){
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new ArrayList<Integer>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<Integer>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }

        int n = adjacentPairs.length + 1;
        int[] ret = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if (adj.size() == 1) {
                ret[0] = e;
                break;
            }
        }

        ret[1] = map.get(ret[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adj = map.get(ret[i - 1]);
            ret[i] = ret[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] adjacentPairs = new int[][]{{4,-2},{1,4},{-3,1}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.restoreArray(adjacentPairs)));
    }
}
