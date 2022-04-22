package leetcode.Three.maxRotateFunction;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：396. 旋转函数
 * @prd : https://leetcode-cn.com/problems/rotate-function/
 * @date ：2022/4/22 11:37 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/22 11:37 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public int maxRotateFunction(int[] nums) {
        int f = 0;
        for (int i = 0; i < nums.length; i++) {
            f += i * nums[i];
        }
        int max = f;
        int sum = Arrays.stream(nums).sum();
        for (int i = nums.length - 1; i > 0; i--) {
            f += sum - nums.length * nums[i];
            max = Math.max(max, f);
        }
        return max;
    }
}
