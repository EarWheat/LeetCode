package leetcode.Two.Thousand.findKOr;

/**
 * @Desc: 2917. 找出数组中的 K-or 值
 * @Author: 泽露
 * @Date: 2024/3/6 10:42 AM
 * @Version: 1.initial version; 2024/3/6 10:42 AM
 */
public class Solution {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            int cnt = 0;
            for (int num : nums) {
                if (((num >> i) & 1) != 0) {
                    ++cnt;
                }
            }
            if (cnt >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
