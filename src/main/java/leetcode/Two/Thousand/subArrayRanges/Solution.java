package leetcode.Two.Thousand.subArrayRanges;

import java.util.Arrays;
import java.util.Map;

/**
 * @author ：liuzhaolu
 * @description：2104. 子数组范围和
 * @prd : https://leetcode-cn.com/problems/sum-of-subarray-ranges/
 * @date ：2022/3/4 10:41 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/4 10:41 上午     liuzhaolu       firstVersion
 */
public class Solution {
    long min = 0;
    long max = 0;
    long pre = 0;
    public long subArrayRanges(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] > max || nums[j] < min){
                    getRangeResult(nums, i, j);
                }
                result += pre;
            }
        }
        return result;
    }

    public void getRangeResult(int[] nums, int i, int j){
        min = nums[i];
        max = nums[i];
        for (int k = i; k <= j; k++) {
            min = Math.min(nums[k], min);
            max = Math.max(nums[k], max);
        }
        pre = max - min;
    }

}
