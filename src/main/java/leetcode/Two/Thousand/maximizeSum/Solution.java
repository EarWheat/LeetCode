package leetcode.Two.Thousand.maximizeSum;

import java.util.Arrays;

/**
 * @Desc: 2656. K 个元素的最大和
 * @Author: 泽露
 * @Date: 2023/11/15 4:12 PM
 * @Version: 1.initial version; 2023/11/15 4:12 PM
 */
public class Solution {
    public int maximizeSum(int[] nums, int k) {
        int m = Arrays.stream(nums).max().getAsInt();
        return (2 * m + k - 1) * k / 2;
    }
}
