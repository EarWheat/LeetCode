package leetcode.Two.Thousand.sumOfMultiples;

/**
 * @Desc: 倍数求和
 * @Author: 泽露
 * @Date: 2023/10/17 3:29 PM
 * @Version: 1.initial version; 2023/10/17 3:29 PM
 */
public class Solution {
    public int sumOfMultiples(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                res += i;
            }
        }
        return res;
    }
}
