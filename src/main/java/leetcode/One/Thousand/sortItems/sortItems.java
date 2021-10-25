package leetcode.One.Thousand.sortItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/12 下午2:10
 * @desc TODO:未完成
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class sortItems {
    /**
     * 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
     * 输出：[6,3,4,1,5,2,0,7]
     * @param n
     * @param m
     * @param group
     * @param beforeItems
     * @return
     */
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        if(group.length == 0 || n == 0){
            return null;
        }
        List<Integer> needSort = new ArrayList<>(); // 需要排序的项目
        Map<Integer, List<Integer>> orderedGroupItem = new HashMap<>(); // 按组排好项目
        for(int i = 0; i < group.length; i++){
            if(group[i] == -1){
                needSort.add(i);
            } else {
                List<Integer> temp;
                if(orderedGroupItem.containsKey(group[i])){
                    temp = orderedGroupItem.get(group[i]);
                } else {
                    temp = new ArrayList<>();
                }
                temp.add(i);
                orderedGroupItem.put(group[i],temp);
            }
        }
        if(needSort.size() == 0){
            return null;
        }
        int[] result = new int[n];
        return result;
    }

    /**
     * 对有前置要求的项目进行排序
     * @param beforeItems
     * @return
     */
    public String orderString(List<List<Integer>> beforeItems, Map<Integer, List<Integer>> orderedGroupItem){

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for(List<Integer> list : beforeItems){

            index++;
        }
        return "";
    }

    /**
     * 组内排序
     * @param orderedGroupItem
     * @param beforeItems
     */
    public void groupInnerOrder(Map<Integer, List<Integer>> orderedGroupItem, List<List<Integer>> beforeItems){
        for(Map.Entry<Integer, List<Integer>> group : orderedGroupItem.entrySet()){
            List<Integer> temp = group.getValue();

        }
    }
}
