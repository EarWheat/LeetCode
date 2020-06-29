package leetcode.findKthLargest;

import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-29 17:54
 * @desc:
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

 */
public class findKthLargest {


    public static int findMax(int[] nums){
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max,nums[i]);
        }
        return max;
    }

    public static int rightAnswer(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
//        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));   // 5
        System.out.println(rightAnswer(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
