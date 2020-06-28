package leetcode.minSubArrayLen;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-28 11:57
 * @desc:
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。

示例: 

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
思路：
* 双指针，一个指向左，开始累计右边和，若大于target开始移动左指针。
 */
public class minSubArrayLen {
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int totalSum = 0;
        int result = nums.length;
        while (right < nums.length){
            sum += nums[right];
            totalSum += nums[right];
            if(sum >= s){
                result = Math.min((right - left + 1),result);
                while (left < right){
                    sum -= nums[left];
                    // 移动左指针
                    left++;
                    // 左指针移动后扔大于target，继续
                    if(sum >= s){
                        result = Math.min((right - left + 1),result);
                    } else {
                        break;
                    }
                }
            }
            right++;
        }
        // 不存在
        if(result == nums.length && totalSum < s){
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));  // 2
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4}));  // 3
        System.out.println(minSubArrayLen(17, new int[]{2,3,1,2,4}));  // 0
        System.out.println(minSubArrayLen(15,new int[]{1,2,3,4,5}));  // 5
    }
}
