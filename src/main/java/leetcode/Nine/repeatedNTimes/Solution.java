package leetcode.Nine.repeatedNTimes;

/**
 * @Desc: https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 * @Author: 泽露
 * @Date: 2022/5/21 7:21 PM
 * @Version: 1.initial version; 2022/5/21 7:21 PM
 */
public class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(result[nums[i] - 1] >= 1){
                return i ;
            } else {
                result[nums[i] - 1]++;
            }
        }
        return -1;
    }
}
