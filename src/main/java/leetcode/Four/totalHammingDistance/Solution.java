package leetcode.Four.totalHammingDistance;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/28 下午2:15
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int result = 0 ;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result += hammingDistance(nums[i],nums[j]);
            }
        }
        return result;
    }

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int distance = 0;
        while (z > 0){
            if((z & 1) == 1){
                distance++;
            }
            z = z >> 1;
        }
        return distance;
    }
}
