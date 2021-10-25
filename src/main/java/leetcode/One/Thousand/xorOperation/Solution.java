package leetcode.One.Thousand.xorOperation;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/7 上午11:02
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int xorOperation(int n, int start) {
        if(n == 1){
            return start;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
