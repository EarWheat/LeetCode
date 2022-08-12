package leetcode.One.Thousand.groupThePeople;

import org.apache.commons.collections.ListUtils;

import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/12 11:41 AM
 * @Version: 1.initial version; 2022/8/12 11:41 AM
 */
public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // Map[多少人,List<人Id>
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int peopleId = i;
            int groupNum = groupSizes[i];
            List<Integer> list;
            if (groupMap.containsKey(groupNum)) {
                list = groupMap.get(groupNum);
            } else {
                list = new ArrayList<>();
            }
            list.add(peopleId);
            groupMap.put(groupNum, list);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : groupMap.entrySet()) {
            Integer groupNum = entry.getKey();
            List<Integer> peoples = entry.getValue();
            if (peoples.size() > groupNum) {
                List<Integer> temp = new ArrayList<>();
                for (Integer people : peoples) {
                    temp.add(people);
                    if (temp.size() == groupNum) {
                        result.add(temp);
                        temp = new ArrayList<>();
                    }
                }
            } else if(groupNum == peoples.size()){
                result.add(peoples);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupThePeople(new int[]{3,3,3,3,3,1,3}));
    }
}
