package leetcode.Four.findPoisonedDuration;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/10 5:59 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/10      liuzhaolu       firstVersion
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int len = timeSeries.length;
        for(int i=1;i<len;i++){
            if(timeSeries[i] >= timeSeries[i-1] + duration){
                res = res + duration;
            }else{
                res = res + (timeSeries[i] - timeSeries[i-1]);
            }
        }
        return res + duration;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPoisonedDuration(new int[]{1,4}, 2));
    }
}
