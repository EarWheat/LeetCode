package leetcode.Five.findUnsortedSubarray;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/3 5:57 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);
        int left = 0;
        while (nums[left] == numsSorted[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numsSorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        Solution solution = new Solution();
        System.out.println(solution.findUnsortedSubarray(nums));
    }
}
