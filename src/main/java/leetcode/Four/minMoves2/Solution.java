package leetcode.Four.minMoves2;

import java.util.Arrays;

/**
 * @Desc: https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 * @Author: 泽露
 * @Date: 2022/5/19 4:15 PM
 * @Version: 1.initial version; 2022/5/19 4:15 PM
 */
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int temp = nums[nums.length / 2];
        for (int i = 0; i < nums.length / 2; i++) {
            result += temp - nums[i];
            result += nums[nums.length - 1 - i] - temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMoves2(new int[]{1,2,9,10}));
    }
}
