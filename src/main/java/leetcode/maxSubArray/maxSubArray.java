package main.java.leetcode.maxSubArray;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-03 13:50
 * @desc:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

 */
public class maxSubArray {
    public static void main(String[] args) {
        int[] test = {-2,-1};
        System.out.println(maxSubArray(test));
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int max = nums[0];  // 默认最大值
        int temp = nums[0]; // 默认temp
        int start;
        for(start = 0; start < nums.length; start++){
            if(nums[start] > 0){
                max = nums[start];
                temp = nums[start];
                break;
            } else {
                max = Math.max(max,nums[start]);
            }
        }
        if(start == nums.length){
            return max;
        }
        for(int i = start + 1 ; i < nums.length; i++){
            temp = temp + nums[i];
            max = Math.max(max,temp);
            if(temp < 0){
                temp = 0;
            }
        }
        return max;
    }


}
