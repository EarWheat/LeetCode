package leetcode.Zero.nextPermutation;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-10 16:33
 * @desc 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 *
 *

 * 链接：https://leetcode-cn.com/problems/next-permutation
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class nextPermutation {
    /**
     * 2,3,5,6,1    -> 2,3,6,5,1
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * 1,3,2 -> 2,1,3
     * 1,4,3,2 -> 2,1,4,3
     * 其实就是从数组倒着查找，找到nums[i] 比nums[i+1]小的时候，就将nums[i]跟nums[i+1]到nums[nums.length - 1]当中找到一个最小的比nums[i]大的元素交换。交换后，再把nums[i+1]到nums[nums.length-1]排序，就ok了
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        boolean switched = false;
        // 冒泡
        int i = nums.length - 1;
        int j;
        while (i >= 0 && !switched){
            j = i - 1;
            while (j >= 0 && !switched){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums,j + 1, nums.length);
                    switched = true;
                }
                j--;
            }
            i--;
        }
        // 若没有交换从小排序
        if(!switched){
            int right = nums.length - 1;
            int left = 0;
            while (left <= right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
//        int[] temp0 = new int[]{2,3,1};
//        nextPermutation(temp0);
//        System.out.println(JSONObject.toJSONString(temp0));
//        int[] temp = new int[]{2,3,5,6,1};
//        nextPermutation(temp);
//        System.out.println(JSONObject.toJSONString(temp));
//        int[] temp1 = new int[]{1,2,3};
//        nextPermutation(temp1);
//        System.out.println(JSONObject.toJSONString(temp1));
//        int[] temp2 = new int[]{4,3,2,1};
//        nextPermutation(temp2);
//        System.out.println(JSONObject.toJSONString(temp2));
//        int[] temp3 = new int[]{1,1,5};
//        nextPermutation(temp3);
//        System.out.println(JSONObject.toJSONString(temp3));
//        int[] temp4 = new int[]{1,3,2};
//        nextPermutation(temp4);
//        System.out.println(JSONObject.toJSONString(temp4));
//        int[] temp5 = new int[]{1,4,3,2};
//        nextPermutation(temp5);
//        System.out.println(JSONObject.toJSONString(temp5));
        int[] temp6 = new int[]{4,2,0,2,3,2,0};
        nextPermutation(temp6);
        System.out.println(JSONObject.toJSONString(temp6));
        int[] temp7 = new int[]{4,2,1,2,3,2,1}; // 4,2,1,3,1,2,2
        nextPermutation(temp7);
        System.out.println(JSONObject.toJSONString(temp7));
    }
}
