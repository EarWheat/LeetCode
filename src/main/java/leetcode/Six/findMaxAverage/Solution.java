package leetcode.Six.findMaxAverage;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/4 下午2:00
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    /**
     * 输入：[1,12,-5,-6,50,3], k = 4
     * 输出：12.75
     * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     */
    public double findMaxAverage(int[] nums, int k) {
        int total = 0;
        // 计算第一个总和
        for (int i = 0; i < k; i++) {
            total += nums[i];
        }
        int maxTotal = total;
        for (int i = 1; i < nums.length - k + 1; i++) {
            int gap = nums[i - 1 + k] - nums[i - 1];
            total += gap;
            maxTotal = Math.max(maxTotal, total);
        }
        return ((double) maxTotal) / k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        Solution solution = new Solution();
        System.out.println(solution.findMaxAverage(nums,4));
    }
}
