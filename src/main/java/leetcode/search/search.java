package main.java.leetcode.search;

import com.alibaba.fastjson.JSONObject;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-27 14:31
 * @desc:假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

* 思路：二分法查找，每次二分之后看左右俩数，如果left < right则数组未反转，然后从小于数的里面找，总之是二分法的变试
 */
public class search {
    public static void main(String[] args) {
        int[] test = {4,5,6,7,0,1,2};
        int[] test2 = {3,5,1};
        int[] test3 = {5,1};
        int[] test4 = {3,4,5,6,1,2};
        int[] test5 = {6,7,1,2,3,4,5};
        int[] test6 = {6,7,8,5,9,10,11};
        System.out.println(search(test,4));
        System.out.println(search(test,2));
        System.out.println(search(test2,4));
        System.out.println(search(test3,5));
        System.out.println(search(test3,1));
        System.out.println(search(test4,2));
        System.out.println(search(test5,6));
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        return index(nums,target,0,nums.length - 1);
//        return answerSearch(nums,0,nums.length -1, target);
    }

    private static int index(int[] nums, int target, int start, int end){
        // 未找到这个数
        if(start == end && nums[start] != target){
            return -1;
        }
        if(end - start == 1){
            if(nums[start] == target){
                return start;
            } else if(nums[end] == target){
                return end;
            }
            return -1;
        }
        // 求中间的数
        int middle = start + (end - start) / 2;
        if(nums[middle] == target){
            return middle;
        }
        // 二分法，其中一个为升序
        if(nums[middle] < nums[end]){
            if(nums[end] >= target && nums[middle] < target){
                return index(nums,target,middle + 1,end);
            }
            return index(nums,target,start,middle - 1);
        } else {
            if(nums[start] <= target && target < nums[middle]){
                return index(nums,target,start,middle -1);
            } else {
                return index(nums,target,middle + 1,end);
            }
        }
    }

    // 二分查找
    private static int answerSearch(int[] nums, int start, int end,int target){
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] < nums[end]) {
            if (nums[mid] < target && target <= nums[end])
                return answerSearch(nums, mid + 1, end, target);
            else
                return answerSearch(nums, start, mid - 1, target);
        } else {
            if (nums[start] <= target && target < nums[mid])
                return answerSearch(nums, start, mid - 1, target);
            else
                return answerSearch(nums, mid + 1, end, target);
        }
    }
}
