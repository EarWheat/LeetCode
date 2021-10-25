package leetcode.One.Thousand.maxFrequency;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/19 下午3:46
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    // 1,4,8,8,13
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        // 求相邻数之间的gap
        int[][] gap = new int[nums.length][nums.length];    // 以nums[i]为目标函数的gap数组
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                gap[i][j] = nums[i] - nums[j];
            }
        }
        // 0,0,0,0,0
        // 3,0,0,0,0
        // 7,4,0,0,0
        // 7,4,0,0,0
        // 12,9,5,5,0
        int max = 0;
        for (int i = 0; i < gap.length; i++) {
            int[] temp = gap[i];
            int j = i;
            int count = 0;
            int tempK = k;
            while (j >= 0 && tempK >= 0){
                if(tempK >= temp[j]){
                    count++;
                    tempK = tempK - temp[j];
                } else {
                    break;
                }
                j--;
            }
            max = Math.max(max,count);
        }
        return max;
    }

    /**
     * 贪心，排序、滑动窗口
     * @param nums
     * @return
     */
    public int answer(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4};
        Solution solution = new Solution();
        System.out.println(solution.maxFrequency(nums,5));
    }
}
