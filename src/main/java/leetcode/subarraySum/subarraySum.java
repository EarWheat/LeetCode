package leetcode.subarraySum;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-15 10:48
 * @desc:给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。

 */
public class subarraySum {

    public static int subarraySum(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        int result = 0;
        int sum = 0;
        for(int i = 0 ;i < nums.length; i++){
            sum = 0;
            if(nums[i] == k){
                result++;
            }
            sum += nums[i];
            for(int j = i + 1; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    result++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] test = {0,0,0,0,0,0,0,0,0,0};
        System.out.println(subarraySum(test,0));
    }
}
