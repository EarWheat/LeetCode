package leetcode.Six.triangleNumber;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/4 7:34 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];
                    if(a + b > c){
                        result++;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
