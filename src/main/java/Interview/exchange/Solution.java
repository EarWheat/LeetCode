package Interview.exchange;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/14 2:08 PM
 * @Version: 1.initial version; 2022/5/14 2:08 PM
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            while (left <= right && nums[left] % 2 == 1) left++;
            while (left <= right && nums[right] % 2 == 0) right--;
            if (left >= right){
                break;
            }
            swap(nums, left, right);
        }
        return nums;
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.exchange(new int[]{1, 2, 3, 4})));
    }
}
