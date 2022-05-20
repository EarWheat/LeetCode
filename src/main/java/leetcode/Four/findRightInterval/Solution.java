package leetcode.Four.findRightInterval;

import java.util.Arrays;

/**
 * @Desc: https://leetcode.cn/problems/find-right-interval/
 * @Author: 泽露
 * @Date: 2022/5/20 2:37 PM
 * @Version: 1.initial version; 2022/5/20 2:37 PM
 */
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval[0] == interval[1]){
                result[i] = 0;
                continue;
            }
            int right = interval[1];
            int step = Integer.MAX_VALUE;
            for (int j = 0; j < intervals.length; j++) {
                if(j == i){
                    continue;
                }
                int[] intervalJ = intervals[j];
                int left = intervalJ[0];
                if(left >= right && (left - right) < step){
                    step = left - right;
                    result[i] = j;
                }
            }
        }
        return result;
    }
}
