package leetcode.Two.Thousand.addMinimum;

/**
 * @Desc: 构造有效字符串的最小插入数
 * @Author: 泽露
 * @Date: 2024/1/11 5:53 PM
 * @Version: 1.initial version; 2024/1/11 5:53 PM
 */
public class Solution {
    public int addMinimum(String word) {
        int n = word.length();
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = d[i - 1] + 2;
            if (i > 1 && word.charAt(i - 1) > word.charAt(i - 2)) {
                d[i] = d[i - 1] - 1;
            }
        }
        return d[n];
    }
}
