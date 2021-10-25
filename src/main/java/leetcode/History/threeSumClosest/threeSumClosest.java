package leetcode.History.threeSumClosest;

import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-24 10:12
 * @desc:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 

示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
*
* 思路：
*1、i，j指针遍历
 */
public class threeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int distance = Integer.MAX_VALUE; // 与target的距离
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int sum = nums[i] + nums[j];     // 前俩数之和
                int temp = target - sum;         // 新的目标值
                for(int k = j + 1; k < nums.length; k++){
                    // 刚好有和为target的值
                    if(nums[k] == temp){
                        return target;
                    }
                    // 新的距离比之前的距离要小
                    if(Math.abs(temp - nums[k]) < distance){
                        distance = Math.abs(temp - nums[k]);
                        result = sum + nums[k];         // 不带绝对值。
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
    }
}
