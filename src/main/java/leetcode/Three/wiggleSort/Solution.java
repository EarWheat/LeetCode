package leetcode.Three.wiggleSort;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/28 5:17 PM
 * @Version: 1.initial version; 2022/6/28 5:17 PM
 */
public class Solution {
    // [1,3,2,2,3,1]
    // 1,1,2,2,3,3
    // 1,2,1,2,3,3
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        if(nums.length % 2 != 0){
            index = nums.length / 2 + 1;
        } else {
            index = nums.length / 2;
        }
        int i = 0;
        while (index < nums.length) {
            int temp = nums[i];
            for (int j = i + 1; j <= index; j++) {
                nums[j - 1] = nums[j];
            }
            nums[index] = temp;
            index++;
        }
    }

//    public void swap(int[] nums, int left, int right) {
//        int temp = nums[left];
//        nums[left] = nums[right];
//        nums[right] = temp;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[]{1,1,2,1,2,2,1};
        solution.wiggleSort(test);
        System.out.println(Arrays.toString(test));
    }
}
