package leetcode.Four.numberOfArithmeticSlices;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/10 4:25 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length  < 3){
            return 0;
        }
        // 定义一个 dp[nums.length] 数组， 记录 dp[i] 以 i 结尾的等差数列子数组的个数
        // dp[2] = nums[0] - nums[1] == nums[1] - nums[2] ? 1 : 0;
        // nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2] ， 如果 i 于前两个构成等差数列的话
        // 必定于 dp[i - 1] 构成等差数列，所以 dp[i] = dp[i - 1] + 1;
        int[] dp = new int[nums.length];
        if(nums[0] - nums[1] == nums[1] - nums[2]){
            dp[2] = 1;
        }

        int sum = dp[2];
        for(int i = 3; i < nums.length ; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                dp[i] = dp[i - 1] + 1 ;
                sum += dp[i];
            }
        }
        return sum;
    }
}