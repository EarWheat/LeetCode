package leetcode.One.Thousand.findCenter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liuzhaolu
 * @description：1791. 找出星型图的中心节点
 * @prd : https://leetcode-cn.com/problems/find-center-of-star-graph/
 * @date ：2022/2/18 2:10 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/18 2:10 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> lines = new HashMap<>();
        for (int[] line : edges) {
            lines.put(line[0], lines.getOrDefault(line[0], 0) + 1);
            lines.put(line[1], lines.getOrDefault(line[1], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : lines.entrySet()){
            if(entry.getValue() == edges.length){
                return entry.getKey();
            }
        }
        return 0;
    }
}
