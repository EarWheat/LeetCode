package leetcode.Four.medianSlidingWindow;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/3 下午3:18
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(k == 1){
            Arrays.sort(nums);
            return Arrays.stream(nums).asDoubleStream().toArray();
        }
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            result[i] = middleNum(Arrays.copyOfRange(nums,i,i + k));
        }
        return result;
    }

    // 求取中位数
    public double middleNum(int[] nums){
        Arrays.sort(nums);
        int middleIndex = nums.length / 2;
        if(nums.length % 2 == 0){
            BigDecimal a = new BigDecimal(nums[middleIndex]);
            BigDecimal b = new BigDecimal(nums[middleIndex - 1]);
            BigDecimal sum = a.add(b);
            double result = sum.divide(new BigDecimal(2)).doubleValue();
            return result;
        } else {
            return nums[middleIndex];
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
//        Solution solution = new Solution();
//        System.out.println(JSONObject.toJSONString(solution.medianSlidingWindow(nums,3)));
        int[] nums = new int[]{2147483647,2147483647};
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.medianSlidingWindow(nums,2)));
    }
}
