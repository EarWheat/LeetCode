package leetcode.Seven.pivotIndex;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/28 上午11:50
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public static int pivotIndex(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        int left = 1;
        int leftSum = 0;
        int totalSum = Arrays.stream(nums).sum();
        int rightSum = totalSum - leftSum -nums[0];
        if(leftSum == rightSum){
            return 0;
        }
        while (left < nums.length){
            leftSum += nums[left - 1];
            rightSum = totalSum - nums[left] - leftSum;
            if(leftSum == rightSum){
                return left;
            }
            left++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-1,-1,-1,0,1,1};
        System.out.println(pivotIndex(test));
    }
}
