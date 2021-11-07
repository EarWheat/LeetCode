package leetcode.Five.maxCount;

import org.checkerframework.checker.units.qual.A;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/7 7:11 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/7      liuzhaolu       firstVersion
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int[][] array = new int[m][n];
        Arrays.stream(ops).forEach(op -> {
            option(array, op);
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(map.containsKey(array[i][j])){
                    map.put(array[i][j],map.get(array[i][j]) + 1);
                } else {
                    map.put(array[i][j],1);
                }
            }
        }
        int result = 0;
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey() >= max){
                max = entry.getKey();
                result = entry.getValue();
            }
        }
        return result;
    }

    public void option(int[][] array, int[] ops){
        int left = ops[0];
        int right = ops[1];
        for (int i = 0; i < left; i++) {
            for (int j = 0; j < right; j++) {
                array[i][j] = ++array[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCount(3,3,new int[][]{{2,2},{3,3}}));
    }
}
