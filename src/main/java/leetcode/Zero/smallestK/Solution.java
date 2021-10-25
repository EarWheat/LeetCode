package leetcode.Zero.smallestK;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/3 4:02 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
    }
}
