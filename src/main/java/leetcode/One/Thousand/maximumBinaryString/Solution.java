package leetcode.One.Thousand.maximumBinaryString;

/**
 * @Desc: 修改后的最大二进制字符串
 * @Author: 泽露
 * @Date: 2024/4/10 6:18 PM
 * @Version: 1.initial version; 2024/4/10 6:18 PM
 */
public class Solution {
    public String maximumBinaryString(String binary) {
        int n = binary.length();
        char[] s = binary.toCharArray();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                while (j <= i || (j < n && s[j] == '1')) {
                    j++;
                }
                if (j < n) {
                    s[j] = '1';
                    s[i] = '1';
                    s[i + 1] = '0';
                }
            }
        }
        return new String(s);
    }
}
