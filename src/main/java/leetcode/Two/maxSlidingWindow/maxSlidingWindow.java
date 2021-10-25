package leetcode.Two.maxSlidingWindow;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/2 上午10:31
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1){
            return nums;
        }
        if(nums.length <= k){
            int[] result = new int[1];
            int temp = 0;
            for(int i = 0; i < nums.length; i++){
                temp = Math.max(temp,nums[i]);
            }
            result[0] = temp;
            return result;
        }
        int length = nums.length - k + 1;
        int[] result = new int[length];
        int maxIndex = 0;   // 最大值索引
        int maxNum = nums[0];    // 最大值
        // 找第一个窗口
        for(int i = 1; i < k; i++){
            if(nums[i] >= maxNum){
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        result[0] = maxNum;
        int p = 1;
        int left = 1;   // 窗口左
        int right = k ;  // 窗口右
        while (right < nums.length){
            if(nums[right] >= maxNum){  // 新增窗口的值更大
                maxNum = nums[right];
                maxIndex = right;
                result[p++] = maxNum;
            } else {    // 新增的值小
                if(left > maxIndex){    // 最大值已经出去了
                    // 重新找窗口中的最大值
                    maxNum = nums[left];
                    maxIndex = left;
                    for(int m = left; m <= right; m++){
                        if(nums[m] >= maxNum){
                            maxNum = nums[m];
                            maxIndex = m;
                        }
                    }
                    result[p++] = maxNum;
                } else {
                    result[p++] = maxNum;
                }
            }
            left++;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{7,2,4};
        System.out.println(JSONObject.toJSONString(maxSlidingWindow(test,2)));
    }

}
