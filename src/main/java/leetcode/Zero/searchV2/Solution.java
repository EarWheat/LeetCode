package leetcode.Zero.searchV2;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/16 下午6:49
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left =0,right = nums.length-1;
        int count = 0;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>=target)
                right=mid;
            if(nums[mid]<target)
                left = mid+1;
        }
        while(left<nums.length&&nums[left++]==target)
            count++;
        return count;
    }
}
