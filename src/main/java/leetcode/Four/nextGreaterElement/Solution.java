package leetcode.Four.nextGreaterElement;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liuzhaolu
 * @date ：2021/10/26 5:24 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/10/26      liuzhaolu       firstVersion
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> bigMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            bigMap.put(nums2[i], findBiger(nums2, i));
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = bigMap.get(nums1[i]);
        }
        return nums1;
    }

    public int findBiger(int[] nums, int i){
        int temp = nums[i];
        for (int j = i + 1; j < nums.length; j++) {
            if(nums[j] > temp){
                return nums[j];
            }
        }
        return -1;
    }
}
