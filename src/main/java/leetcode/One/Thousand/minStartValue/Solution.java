package leetcode.One.Thousand.minStartValue;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/9 7:12 PM
 * @Version: 1.initial version; 2022/8/9 7:12 PM
 */
public class Solution {
    public int minStartValue(int[] nums) {
        int result = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[0];
            if(temp < 0){
                result = Math.min(result, temp);
            }
        }
        return Math.abs(result);
    }
}
