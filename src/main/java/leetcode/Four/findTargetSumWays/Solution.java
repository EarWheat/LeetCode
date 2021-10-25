package leetcode.Four.findTargetSumWays;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/7 下午3:31
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == 0 && target == 0){
                return 2;
            }
            if(nums[0] == target || nums[0] == 0 - target){
                return 1;
            }
            return 0;
        }
        int result = 0;
        result += findTargetSumWays(Arrays.copyOfRange(nums,1,nums.length), target - nums[0]);
        result += findTargetSumWays(Arrays.copyOfRange(nums,1,nums.length), target + nums[0]);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1,0},1));
    }
}
