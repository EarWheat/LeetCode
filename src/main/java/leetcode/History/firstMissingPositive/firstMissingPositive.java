package leetcode.History.firstMissingPositive;

import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-27 15:18
 * @desc:
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

 

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1

* 1、假设1存在
* for(int i = 0; i< Integer.MAX_VALUE; i++){
*       if(nums[i] == start){
*          start++;
*       }
*       if(nums[i] > start){
*          return start;
*       }
* }
*
* 思路答案：
* 1、找出数组中最大值以及数组正数的个数，即可通过求前N项式正数和的方法，求缺少的最小正整数
 */
public class firstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int start = 1; // 起初位置
        for(int i = 0; i < Integer.MAX_VALUE; i++){
            if(i >= nums.length){
                return start;
            }
            if(nums[i] == start){
                start++;
            }
            if(nums[i] > start){
                return start;
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,3,3,2,3,41,2,32,3,4,2,3,1,4,5,6,7,2}));
        System.out.println(firstMissingPositive(new int[]{}));
    }
}
