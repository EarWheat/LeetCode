package leetcode.Nine.isInterleave;

/**
 * @author ：liuzhaolu
 * @description：97. 交错字符串
 * @prd : https://leetcode-cn.com/problems/interleaving-string/
 * @date ：2022/2/28 11:07 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/28 11:07 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        if (s1.length() == 0) {
            return s2.equalsIgnoreCase(s3);
        }
        if (s2.length() == 0) {
            return s1.equalsIgnoreCase(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        while (true) {
            if (index1 >= s1.length()) {
                return s2.substring(index2).equalsIgnoreCase(s3.substring(index3));
            }
            if (index2 >= s2.length()) {
                return s1.substring(index1).equalsIgnoreCase(s3.substring(index3));
            }
            if (s1.charAt(index1) == s3.charAt(index3) && s2.charAt(index2) != s3.charAt(index3)) {
                index1++;
                index3++;
            } else if (s1.charAt(index1) != s3.charAt(index3) && s2.charAt(index2) == s3.charAt(index3)) {
                index2++;
                index3++;
            } else if (s1.charAt(index1) == s3.charAt(index3) && s2.charAt(index2) == s3.charAt(index3)) {
                if (!isInterleave(s1.substring(index1 + 1), s2.substring(index2), s3.substring(index3 + 1))) {
                    return isInterleave(s1.substring(index1), s2.substring(index2 + 1), s3.substring(index3 + 1));
                }
            } else {
                return false;
            }
        }
    }

    public boolean answer(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isInterleave("aabb","ccdd","aabbccdd"));
//        System.out.println(solution.isInterleave("ccdd","aabb","aabbccdd"));
        System.out.println(solution.isInterleave("aabccd", "eeasfccd", "aaeeasfbccccdd"));
    }
}
