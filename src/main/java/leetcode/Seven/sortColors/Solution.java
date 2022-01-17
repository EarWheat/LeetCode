package leetcode.Seven.sortColors;

/**
 * @author ：liuzhaolu
 * @description：75. 颜色分类
 * @prd : https://leetcode-cn.com/problems/sort-colors/
 * @date ：2022/1/17 2:54 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/17 2:54 下午     liuzhaolu       firstVersion
 */
public class Solution {
    // 0,1,1,0,1,2,2,2,2
    // 1,0,0,1,1,2,2,2,2
    // 1,1,1,1,2,2,2
    public void sortColors(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            }else if(nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            }else {
                nums[num2++] = 2;
            }
        }
    }

    public void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,1};
        Solution solution = new Solution();
        solution.sortColors(nums);
    }

}
