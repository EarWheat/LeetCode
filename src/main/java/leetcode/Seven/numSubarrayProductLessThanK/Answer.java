package leetcode.Seven.numSubarrayProductLessThanK;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/5 6:49 PM
 * @Version: 1.initial version; 2022/5/5 6:49 PM
 */
public class Answer {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) {
            return 0;
        }

        int left = 0;
        int product = 1;
        int res = 0;
        for(int right = 0; right < nums.length;) {
            product *= nums[right];
            //若窗口内乘积开始大于等于k 则缩小窗口至满足要求
            while(product >= k && left <= right) {
                product /= nums[left];
                left++;
            }
            //根据窗口长度L 新增一个元素 则将会多出L个满足要求的子数组
            int len = right - left + 1;
            res += len;
            right++;
        }

        return res;
    }
}
