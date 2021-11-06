package leetcode.Two.missingNumber;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/6 4:37 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/6      liuzhaolu       firstVersion
 */
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }
}
