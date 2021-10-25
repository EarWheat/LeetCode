package leetcode.Nine.removeStones;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/15 上午10:20
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class removeStones {
    /**
     * 1,1,0
     * 1,0,1
     * 0,1,1
     * @param stones
     * @return
     * 1,0,1
     * 0,1,0
     * 1,0,1
     */
    public static int removeStones(int[][] stones) {
        if(stones.length == 0){
            return 0;
        }
        Map<Integer, Integer> stoneLine = new HashMap<>();  // 行的石头数
        Map<Integer, Integer> stoneCell = new HashMap<>();  // 列的石头数
        for (int i = 0; i < stones.length; i++) {
            int[] stone = stones[i];
            if(stoneLine.containsKey(stone[0])){
                stoneLine.put(stone[0], stoneLine.get(stone[0]) + 1);
            } else {
                stoneLine.put(stone[0], 1);
            }
            if(stoneCell.containsKey(stone[1])){
                stoneCell.put(stone[1], stoneCell.get(stone[1]) + 1);
            } else {
                stoneCell.put(stone[1], 1);
            }
        }
//        int[] line = new int[stoneLine.size()];
//        int[] cell = new int[stoneCell.size()];
//        for(Map.Entry<Integer, Integer> entry : stoneLine.entrySet()){
//            line[entry.getKey()] = entry.getValue();
//        }
//        for(Map.Entry<Integer, Integer> entry : stoneCell.entrySet()){
//            cell[entry.getKey()] = entry.getValue();
//        }
        int result = 0;
        int flag = 1;
        while (flag == 1){
            System.out.println("line:"+ JSONObject.toJSONString(stoneLine));
            System.out.println("cell:"+ JSONObject.toJSONString(stoneCell));
            flag = removeStone(stoneLine, stoneCell);
            if(flag == 1){
                result++;
            }
        }
        return result;
    }

    /**
     * 移除石头
     * @param stoneLine
     * @param stoneCell
     * @return
     */
    public static int removeStone(Map<Integer, Integer> stoneLine, Map<Integer, Integer> stoneCell){
        int[] location = new int[2];    // 坐标
        int maxLine = 0;    // 最多石头的行
        int maxCell = 0;    // 最多石头的列
        // 找到最多的行列location
        for(Map.Entry<Integer, Integer> entry : stoneLine.entrySet()){
            if(entry.getValue() > 1 && entry.getValue() >= maxLine){
                maxLine = entry.getValue();
                location[0] = entry.getKey();
            }
        }
        for(Map.Entry<Integer, Integer> entry : stoneCell.entrySet()){
            if(entry.getValue() > 1 && entry.getValue() >= maxCell){
                maxCell = entry.getValue();
                location[1] = entry.getKey();
            }
        }
        // 没有可以移除的石头
        if(maxCell == 0 && maxLine == 0){
            return 0;
        }
        System.out.println("max location:"+JSONObject.toJSONString(location));
        // 移除该石头
        stoneLine.put(location[0], stoneLine.get(location[0]) - 1);
        stoneCell.put(location[1], stoneCell.get(location[1]) - 1);
        return 1;
    }

    public static void main(String[] args) {
        int[][] stones = new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}};
        System.out.println(removeStones(stones));
    }
}
