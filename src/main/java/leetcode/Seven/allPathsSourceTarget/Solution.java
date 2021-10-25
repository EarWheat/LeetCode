package leetcode.Seven.allPathsSourceTarget;

import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/25 10:13 上午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph.length == 0){
            return new ArrayList<>();
        }
        return sourceTargetFrom(0,graph);
    }

    public List<List<Integer>> sourceTargetFrom(int src, int[][] graph) {
        if(src == graph.length - 1){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] dest = graph[src];
        int target = graph.length - 1;
        for (int d : dest) {
            if (d == target) {
                LinkedList<Integer> temp = new LinkedList<>();
                temp.add(src);
                temp.add(target);
                result.add(temp);
            } else {
                List<List<Integer>> temp = sourceTargetFrom(d, graph);
                for (List<Integer> t : temp) {
                    LinkedList<Integer> t2 = new LinkedList<>();
                    t2.add(src);
                    t2.addAll(t);
                    result.add(t2);
                }
            }
        }
        return result;
    }
}
