package leetcode.Six.findKthNumber;

/**
 * @Desc: 668. 乘法表中第k小的数
 * @Author: 泽露
 * @Date: 2022/5/18 2:25 PM
 * @Version: 1.initial version; 2022/5/18 2:25 PM
 */
public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
}
