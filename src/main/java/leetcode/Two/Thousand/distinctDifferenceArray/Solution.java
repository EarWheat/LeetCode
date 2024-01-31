package leetcode.Two.Thousand.distinctDifferenceArray;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc: 找出不同元素数目差数组
 * @Author: 泽露
 * @Date: 2024/1/31 6:19 PM
 * @Version: 1.initial version; 2024/1/31 6:19 PM
 */
public class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        int[] sufCnt = new int[n + 1];
        for (int i = n - 1; i > 0; i--) {
            set.add(nums[i]);
            sufCnt[i] = set.size();
        }
        int[] res = new int[n];
        set.clear();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            res[i] = set.size() - sufCnt[i + 1];
        }
        return res;
    }
}
