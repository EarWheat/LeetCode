package leetcode.Five.singleNonDuplicate;

/**
 * @author ：liuzhaolu
 * @description：540. 有序数组中的单一元素
 * @prd : https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * @date ：2022/2/14 11:15 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/14 11:15 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return quickSort(nums, 0, nums.length - 1);
    }

    public int quickSort(int[] nums, int left, int right) {
        if (right - left == 1) {
            if(left == 0){
                return nums[left];
            } else {
                return nums[right];
            }
        }
        int mid = (right + left) / 2;
        if (mid % 2 == 0) {
            if (nums[mid - 1] == nums[mid]) return quickSort(nums, left, mid);
            if (nums[mid + 1] == nums[mid]) return quickSort(nums, mid, right);
        } else {
            if (nums[mid - 1] == nums[mid]) return quickSort(nums, mid, right);
            if (nums[mid + 1] == nums[mid]) return quickSort(nums, left, mid);
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 7, 7, 10, 10, 11, 11};
        Solution solution = new Solution();
        System.out.println(solution.singleNonDuplicate(nums));
    }
}
