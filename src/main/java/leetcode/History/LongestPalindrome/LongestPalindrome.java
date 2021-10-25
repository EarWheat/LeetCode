package leetcode.History.LongestPalindrome;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-25 15:52
 * @desc:给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

 */
public class LongestPalindrome {
    public static void main(String[] args){

    }

    public String longestPalindrome(String s) {
        if(s == null || s.equals("")) {
            return s;
        }

        int len = s.length();
        char[] chars = s.toCharArray();

        boolean[][] dp = new boolean[len][len];
        // 1字母初始化
        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 2字母初始化 P(i,i+1)=(Si==Si+1)
        for(int i = 0; i < len - 1; i++) {
            dp[i][i+1] = (chars[i] == chars[i+1]);
        }

        int left = 0;
        int right = 0;
        int max = 0;
        for(int i = len - 2; i >= 0; i--) {
            for(int j = 1; j < len; j++) {
                // P(i,j)=(P(i+1,j−1) and Si==Sj)
                if(i != j && j != i+1) {
                    dp[i][j] = dp[i+1][j-1] && chars[i] == chars[j];
                }
                if(dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
    }
}
