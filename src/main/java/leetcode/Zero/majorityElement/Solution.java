package leetcode.Zero.majorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/9 下午4:31
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if(counts.containsKey(nums[i])){
                int temp = counts.get(nums[i]);
                temp += 1;
                counts.put(nums[i], temp);
                if(temp > nums.length / 2){
                    return nums[i];
                }
            } else {
                counts.put(nums[i], 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,9,5,9,5,5,5};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
