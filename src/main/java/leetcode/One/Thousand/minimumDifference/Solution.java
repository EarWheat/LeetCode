package leetcode.One.Thousand.minimumDifference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ：liuzhaolu
 * @description：1984. 学生分数的最小差值
 * @prd : https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 * @date ：2022/2/11 2:28 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/11 2:28 下午     liuzhaolu       firstVersion
 */
public class Solution {
    // 思路全排列求步长
    public int minimumDifference(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        Arrays.sort(nums);
        int right = k - 1;
        int result = Integer.MAX_VALUE;
        while (right < nums.length){
            result = Math.min(nums[right] - nums[right + 1 - k], result);
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{87063,61094,44530,21297,95857,93551,9918};
        System.out.println(solution.minimumDifference(nums,6));
    }
}
