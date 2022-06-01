package leetcode.Four.makesquare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/1 1:46 PM
 * @Version: 1.initial version; 2022/6/1 1:46 PM
 */
public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if(sum % 4 != 0){
            return false;
        }
        int line = sum / 4;
        Arrays.sort(matchsticks);
        return allocate(matchsticks, matchsticks.length - 1, new int[4], sum / 4);
    }

    private boolean allocate(int[] nums, int pos, int[] sums, int avg) {
        if (pos == -1)
            return sums[0] == avg && sums[1] == avg && sums[2] == avg;
        for (int i = 0; i < 4; ++i) {
            if (sums[i] + nums[pos] > avg) continue;
            sums[i] += nums[pos];
            if (allocate(nums, pos - 1, sums, avg))
                return true;
            sums[i] -= nums[pos];
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makesquare(new int[]{10,6,5,5,5,3,3,3,2,2,2,2}));
    }

}
