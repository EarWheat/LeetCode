package leetcode.Five.findMinDifference;

import java.util.*;

/**
 * @author ：liuzhaolu
 * @description：539. 最小时间差
 * @prd : https://leetcode-cn.com/problems/minimum-time-difference/
 * @date ：2022/1/18 2:02 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/18 2:02 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        LinkedList<Integer> mins = new LinkedList<>();
        for(String s : timePoints){
            Integer temp = timePoints2min(s);
            if(mins.contains(temp)){
                return 0;
            }
            mins.add(temp);
        }
        mins.sort((o1, o2) -> {
            if(o1 < o2){
                return -1;
            } else if(o1 > o2){
                return 1;
            }
            return 0;
        });
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < mins.size(); i++) {
            result = Math.min(mins.get(i) - mins.get(i - 1), result);
        }
        // 最大和最小相减
        result = Math.min(mins.get(0) + (24 * 60) - mins.get(mins.size() - 1), result);
        return result;
    }

    /**
     * 时间字符串转分
     * @param timePoints
     * @return
     */
    public Integer timePoints2min(String timePoints){
        String[] time = timePoints.split(":");
        String hour = time[0];
        String min = time[1];
        return Integer.parseInt(hour) * 60 + Integer.parseInt(min);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.timePoints2min("01:10"));
    }
}
