package leetcode.Two.Thousand.applyOperations;

/**
 * @Desc: 对数组进行操作
 * @Author: 泽露
 * @Date: 2023/6/5 3:03 PM
 * @Version: 1.initial version; 2023/6/5 3:03 PM
 */
public class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
