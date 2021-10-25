package leetcode.Five.pickIndex;

import java.util.Arrays;
import java.util.Random;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/30 7:50 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    private int[] preSum;
    private int sum;

    public Solution(int[] w) {
        preSum = new int[w.length+1];
        preSum[0] = 0;
        for (int i = 1; i <= preSum.length-1; i++) {
            preSum[i] = preSum[i - 1] + w[i-1];
        }
        sum = preSum[preSum.length-1];
    }

    public int pickIndex() {
        int r = new Random().nextInt(sum);
        return binSearchPreSumReturnWIndex(r);
    }

    private int binSearchPreSumReturnWIndex(int r) {
        int start = 0;
        int end = preSum.length - 1;
        int memo = 0;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (preSum[mid] == r) {
                return mid;
            }
            if (preSum[mid] < r) {
                memo = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return memo;
    }
}
