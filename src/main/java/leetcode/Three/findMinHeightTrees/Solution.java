package leetcode.Three.findMinHeightTrees;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：liuzhaolu
 * @description：310. 最小高度树
 * @prd : https://leetcode-cn.com/problems/minimum-height-trees/
 * @date ：2022/4/6 7:11 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/6 7:11 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        while (edges.length > 0){
            int maxKey = -1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] edge : edges) {
                int key = edge[0];
                map.put(key, map.getOrDefault(key, 0) + 1);
                if(map.get(key) >= maxKey){
                    maxKey = key;
                }
            }
            List<int[]> array = new ArrayList<>();
            for (int[] edge : edges) {
                int key = edge[0];
                if(key != map.get(maxKey)){
                    array.add(edge);
                }
            }
            int[][] newEdges = new int[array.size()][2];
            int i = 0;
            for(int[] e : array){
                newEdges[i++] = e;
            }
            edges = newEdges;
        }
        return null;
    }
}
