package leetcode.Two.Thousand.maxArrayValue;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2024/3/14 2:09 PM
 * @Version: 1.initial version; 2024/3/14 2:09 PM
 */
public class Solution {
    public long maxArrayValue(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
           return nums[1] > nums[0] ? nums[1] + nums[0] : nums[0];
        }
        if (nums[0] + nums[1] <= nums[2] || nums[1] > nums[2]) {
            int[] newNums = new int[nums.length - 1];
            int sum = nums[0] + nums[1];
            newNums[0] = sum;
            for (int i = 1; i < newNums.length; i++) {
                newNums[i] = nums[i + 1];
            }
            return maxArrayValue(newNums);
        } else {
            int[] newNums = new int[nums.length - 1];
            int sum = nums[1] + nums[2];
            newNums[0] = nums[0];
            newNums[1] = sum;
            for (int i = 2; i < newNums.length; i++) {
                newNums[i] = nums[i + 1];
            }
            return maxArrayValue(newNums);
        }
    }

    public long answer(int[] nums) {
        long sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sum = nums[i] <= sum ? nums[i] + sum : nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArrayValue(new int[]{2,3,7,9,3}));
    }
}
