package leetcode.Seven.numMatchingSubseq;
//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
//
//
// 例如， “ace” 是 “abcde” 的子序列。
//
//
//
//
// 示例 1:
//
//
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
//
//
// Example 2:
//
//
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
//
//
//
//
// 提示:
//
//
// 1 <= s.length <= 5 * 10⁴
// 1 <= words.length <= 5000
// 1 <= words[i].length <= 50
// words[i]和 s 都只由小写字母组成。
//
// Related Topics 字典树 哈希表 字符串 排序 👍 268 👎 0

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/11/17 11:02 AM
 * @Version: 1.initial version; 2022/11/17 11:02 AM
 */
public class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Long count = Arrays.stream(words).filter(word -> {
            return isSubString(word, s);
        }).count();
        return count.intValue();
    }

    /**
     * 判断a是不是b的子串
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isSubString(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            while (j < b.length() && a.charAt(i) != b.charAt(j)) {
                j++;
            }
            // 相等
            if (j < b.length()) {
                j++;
                i++;
            }
        }
        return i == a.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubString("bb", "abcde"));
    }
}
