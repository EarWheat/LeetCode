package leetcode.History.searchInsert;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-17 15:41
 * @desc:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0

* 思路：二分查找
 */
public class searchInsert {
    public static int searchInsert(int[] nums, int target) {
        return erfenSearch(0,nums.length,nums,target);
    }

    public static int erfenSearch(int left, int right, int[] nums, int target){
        if(left >= right){
            if(left == nums.length){
                return left;
            }
            if(target > nums[left]){
                return left + 1;
            }
            return left;
        }
        int middle = (right + left) / 2;
        if(nums[middle] == target){
            return middle;
        }
        if(target < nums[middle]){
            return erfenSearch(left,middle - 1,nums,target);
        } else {
            return erfenSearch(middle + 1,right,nums,target);
        }
    }

    public static void main(String[] args) {
//        System.out.println(searchInsert(new int[]{1,3,5,6},5));
//        System.out.println(searchInsert(new int[]{1,3,5,6},2));
//        System.out.println(searchInsert(new int[]{1,3,5,6},7));
//        System.out.println(searchInsert(new int[]{1,3,5,6},0));
        System.out.println(searchInsert(new int[]{1,3},2));
    }
}
