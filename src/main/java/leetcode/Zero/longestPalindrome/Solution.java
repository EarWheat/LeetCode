package leetcode.Zero.longestPalindrome;

/**
 * @author ：liuzhaolu
 * @description：5. 最长回文子串
 * @prd : https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @date ：2022/4/7 5:21 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/7 5:21 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 1) {
            return s;
        }
        int maxLength = Integer.MIN_VALUE;
        String res = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                int left = i;
                int right = i + 1;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                if (right - left > maxLength) {
                    maxLength = right - left;
                    res = s.substring(left + 1, right);
                }
            }
            if (i < s.length() - 2 && s.charAt(i) == s.charAt(i + 2)) {
                int left = i;
                int right = i + 2;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                if (right - left > maxLength) {
                    maxLength = right - left;
                    res = s.substring(left + 1, right);
                }
            }
        }
        return res;
    }
}
