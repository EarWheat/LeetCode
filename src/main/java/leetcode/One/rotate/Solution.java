package leetcode.One.rotate;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/8 下午4:26
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    /**
     * 翻转
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    // [1,2,3,4,5,6,7]
    public void rotate_2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);        // [7,6,5,4,3,2,1]
        reverse(nums, 0, k - 1);        // [5,6,7,4,3,2,1]
        reverse(nums, k, n - 1);              // [5,6,7,1,2,3,4]
    }


    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
