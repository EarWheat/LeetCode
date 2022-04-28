package leetcode.Nine.sortArrayByParity;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: liuzhaolu
 * @Date: 2022/4/28 6:03 PM
 * @Version: 1.initial version; 2022/4/28 6:03 PM
 */
public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right && right < nums.length) {
            while (left < nums.length && nums[left] % 2 == 0) left++;
            while (right >= 0 && nums[right] % 2 == 1) right--;
            if(left >= right){
                break;
            }
            swap(nums, left, right);
        }
        return nums;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArrayByParity(new int[]{3, 1, 2, 4})));
    }
}
