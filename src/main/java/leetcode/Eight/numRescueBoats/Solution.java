package leetcode.Eight.numRescueBoats;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/26 5:12 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int result = 0;
        while (left <= right){
            if(people[left] + people[right] > limit){
                // 先载最重的
                result++;
                right--;
            } else {
                result++;
                left++;
                right--;
            }
        }
        return result;
    }
}
