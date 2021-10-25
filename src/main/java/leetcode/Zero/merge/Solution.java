package leetcode.Zero.merge;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/5 下午4:56
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int i = 0; int j = 0;int index = 0;
        while (i < m && j < n){
            if(nums1[i] < nums2[j]){
                nums3[index] = nums1[i];
                i++;
            } else {
                nums3[index] = nums2[j];
                j++;
            }
            index++;
        }
        if(index < m + n && i < m){
            while (i < m){
                nums3[index++] = nums1[i++];
            }
        }
        if(index < m + n && j < n){
            while (j < n){
                nums3[index++] = nums2[j++];
            }
        }
        for (int k = 0; k < nums3.length; k++) {
            nums1[k] = nums3[k];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        Solution solution = new Solution();
        solution.merge(nums1,3,nums2,3);
        System.out.println(JSONObject.toJSONString(nums1));
    }

}
