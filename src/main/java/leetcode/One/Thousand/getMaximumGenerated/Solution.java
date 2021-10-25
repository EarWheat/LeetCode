package leetcode.One.Thousand.getMaximumGenerated;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/23 5:27 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int i = 1;
        int max = Integer.MIN_VALUE;
        while ((i * 2) <= n){
            nums[i * 2] = nums[i];
            max = Math.max(nums[i * 2], max);
            if((i * 2) + 1 <= n){
                nums[(i * 2) + 1] = nums[i] + nums[i + 1];
                max = Math.max(nums[(i * 2) + 1], max);
            }

            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaximumGenerated(15));
    }
}
