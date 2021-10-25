package leetcode.Six.findErrorNums;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/4 下午5:36
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] counter = new int[nums.length+1];

        for (int i: nums) {
            counter[i]++;
        }

        int[] result = new int[2];
        for (int i = 1; i<counter.length; i++) {
            if (counter[i] == 0) {
                result[1] = i;
            } else if (counter[i] == 2) {
                result[0] = i;
            }
        }

        return result;
    }
}
