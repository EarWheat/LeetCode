package leetcode.One.corpFlightBookings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/31 7:47 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        Arrays.stream(bookings).forEach(book -> {
            int left = book[0] - 1;
            int right = book[1] - 1;
            int value = book[2];
            for (int i = left; i <= right; i++) {
                result[i] += value;
            }
        });
        return result;
    }
}
