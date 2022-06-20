package leetcode.One.Thousand.getMaxLen;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/20 3:13 PM
 * @Version: 1.initial version; 2022/6/20 3:13 PM
 */
public class Solution {
    public int getMaxLen(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                return Math.max(getMaxLen(Arrays.copyOfRange(nums,0,i)), getMaxLen(Arrays.copyOfRange(nums,i + 1, nums.length)));
            }
        }
        int sub = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                sub++;
            }
        }
        if(sub % 2 == 0){
            return nums.length;
        } else {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                if(nums[left] > 0){
                    left++;
                } else {
                    return nums.length - left - 1;
                }
                if(nums[right] > 0){
                    right--;
                } else {
                    return right;
                }
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaxLen(new int[]{0,1,-2,-3,-4}));
    }
}
