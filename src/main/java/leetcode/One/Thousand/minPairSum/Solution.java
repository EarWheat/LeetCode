package leetcode.One.Thousand.minPairSum;


import java.util.Arrays;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/20 下午4:26
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int minPairSum(int[] nums) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < (nums.length / 2); i++) {
            max = Math.max(max,nums[i] + nums[nums.length - 1 - i]);
        }
        return max;
    }
}
