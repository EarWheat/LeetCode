package leetcode.Three.maxNumber;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-02 17:51
 * @desc 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 示例 1:
 *
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 *
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 *
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 *
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class maxNumber {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        if(nums1.length == 0){
            return numsMax(nums2,k);
        }
        if(nums2.length == 0){
            return numsMax(nums1,k);
        }
        // 找出两个数组中的最大值
        Map<Integer, int[]> max1 = maxNum(nums1,k);
        Map<Integer, int[]> max2 = maxNum(nums2,k);
        System.out.println(JSONObject.toJSONString(max1));
        System.out.println(JSONObject.toJSONString(max2));
        // 各种组合的情况
        for(int i = 0; i < nums1.length; i++){

        }
        return nums1;
    }

    public static int[] formatMaxNum(int[] num1,int[] num2){
        int resultLen = num1.length + num2.length;
        int[] result = new int[resultLen];
        int index1 = 0; // num1指针
        int index2 = 0; // num2指针
        for(int i = 0; i < resultLen; i++){
            if(num2[index2] > num1[index1]){
                result[i] = num2[index2];
                index2++;
                while (num2[index2] < num1[index1]){
                    index2++;
                    break;
                }
            }
        }
        return result;
    }

    // map，key N位数的，value 最大值的
    public static Map<Integer, int[]> maxNum(int[] num, int k){
        Map<Integer, int[]> result = new HashMap<>();
        int length = Math.min(num.length,k);
        for(int i = 0; i < length; i++){
            result.put(i + 1,numsMax(num,i + 1));
        }
        return result;
    }

    // 单个数组中找最大值
    public static int[] numsMax(int[] nums, int k){
        int[] result = new int[k];
        int max = -1;
        int index = -1;
        for(int i = 0; i <= nums.length - k; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        result[0] = max;
        if(k == 1){
            return result;
        } else {
            int[] temp = numsMax(Arrays.copyOfRange(nums,index + 1,nums.length),k -1);
            for(int i = 0; i < temp.length;i++){
                result[i + 1] = temp[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        System.out.println(JSONObject.toJSONString(maxNumber(nums1,nums2,5)));
    }


}
