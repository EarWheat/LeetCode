package leetcode.One.generateTheString;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/1 6:56 PM
 * @Version: 1.initial version; 2022/8/1 6:56 PM
 */
public class Solution {
    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if (n % 2 == 0) {
            stringBuilder.append('a');
            n = n - 1;
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append('b');
        }
        return stringBuilder.toString();
    }
}
