package leetcode.Nine.smallestRangeI;

/**
 * @Desc: https://leetcode.cn/problems/smallest-range-i/
 * @Author: 泽露
 * @Date: 2022/4/30 4:19 PM
 * @Version: 1.initial version; 2022/4/30 4:19 PM
 */
public class Solution {
    public int smallestRangeI(int[] nums, int k) {
        if(nums.length <= 1){
            return 0;
        }
        int maxNums = Math.max(nums[0], nums[1]);
        int minNums = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            maxNums = Math.max(maxNums, nums[i] - k);
            if(maxNums <= minNums){
                return 0;
            }
            minNums = Math.min(minNums, nums[i] + k);
            if(minNums >= maxNums){
                return 0;
            }
        }
        return maxNums - minNums;

    }
}
