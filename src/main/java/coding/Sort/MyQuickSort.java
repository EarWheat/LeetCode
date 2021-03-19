package coding.Sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/19 上午10:45
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class MyQuickSort {
    public int[] QuickSort(int[] nums){
        if(nums.length == 1){
            return nums;
        }
        return sort(nums,0,nums.length - 1);
    }

    public int[] sort(int[] nums, int left, int right){
        if(left >= right){
            return nums;
        }
        int temp = nums[left];
        int length = right;
        while (left < right){
            while (left < right && nums[right] >= temp){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        sort(nums,0,left-1);
        sort(nums,left + 1, length);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,3,2,7,8,9,1,2,5,4};
        MyQuickSort myQuickSort = new MyQuickSort();
        System.out.println(JSONObject.toJSONString(myQuickSort.QuickSort(nums)));
    }
}
