package Interview.majorityElement;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/6 4:37 PM
 * @Version: 1.initial version; 2022/7/6 4:37 PM
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
