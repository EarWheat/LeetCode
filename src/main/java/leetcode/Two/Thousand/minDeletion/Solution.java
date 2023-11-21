package leetcode.Two.Thousand.minDeletion;

/**
 * @Desc: 2216. 美化数组的最少删除数
 * @Author: 泽露
 * @Date: 2023/11/21 7:44 PM
 * @Version: 1.initial version; 2023/11/21 7:44 PM
 */
public class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        boolean check = true;
        for (int i = 0; i + 1 < n; ++i) {
            if (nums[i] == nums[i + 1] && check) {
                ++ans;
            } else {
                check = !check;
            }
        }
        if ((n - ans) % 2 != 0) {
            ++ans;
        }
        return ans;
    }
}