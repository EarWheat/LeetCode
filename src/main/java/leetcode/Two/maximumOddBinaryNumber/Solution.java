package leetcode.Two.maximumOddBinaryNumber;

/**
 * @Desc: 2864. 最大二进制奇数
 * @Author: 泽露
 * @Date: 2024/3/13 3:30 PM
 * @Version: 1.initial version; 2024/3/13 3:30 PM
 */
public class Solution {
    public String maximumOddBinaryNumber(String s) {
        int numOf1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                numOf1++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numOf1 - 1; i++) {
            stringBuilder.append("1");
        }
        for (int i = 0; i < s.length() - numOf1; i++) {
            stringBuilder.append("0");
        }
        stringBuilder.append("1");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumOddBinaryNumber("010"));
    }
}
