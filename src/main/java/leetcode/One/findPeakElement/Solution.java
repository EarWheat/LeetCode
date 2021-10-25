package leetcode.One.findPeakElement;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/15 6:06 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement(nums));
    }
}
