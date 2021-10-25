package leetcode.Zero.searchRange;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-01 11:23
 * @desc 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class searchRange {
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        // 先二分
        int index = findIndex(nums,0,nums.length,target);
        if(index == -1){
            return new int[]{-1,-1};
        }
        // 两边扩散
        int[] result = new int[]{index,index};
        for(int i = index - 1; i >= 0; i--){
            if(nums[i] == target){
                result[0] = i;
            } else {
                break;
            }
        }
        for(int i = index; i < nums.length;i++){
            if(nums[i] == target){
                result[1] = i;
            } else {
                break;
            }
        }
        return result;
    }

    public static int findIndex(int[] nums, int left, int right, int target){
        if(left == right){
            if(left >= nums.length){
                return -1;
            }
            return nums[left] == target ? left : -1;
        }
        if(left >= right){
            return -1;
        }
        // 先二分
        int middle = (left + right) / 2;
        if(nums[middle] == target){
            return middle;
        }
        if(target > nums[middle]){
            return findIndex(nums,middle + 1, right, target);
        } else {
            return findIndex(nums,left,middle,target);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{5,7,7,8,8,10};
        int[] test2 = new int[]{2,2};
//        System.out.println(JSONObject.toJSONString(searchRange(test2,2)));
        System.out.println(JSONObject.toJSONString(searchRange(test,8)));
    }
}
