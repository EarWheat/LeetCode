package leetcode.Seven.longestWord;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：liuzhaolu
 * @description：720. 词典中最长的单词
 * @prd : https://leetcode-cn.com/problems/longest-word-in-dictionary/
 * @date ：2022/3/17 10:48 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/17 10:48 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (s1, s2) -> {
            if (s1.length() < s2.length()) {
                return -1;
            } else if (s1.length() == s2.length()) {
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) < s2.charAt(i)) {
                        return 1;
                    } else if (s1.charAt(i) > s2.charAt(i)) {
                        return -1;
                    }
                }
                return 0;
            } else {
                return 1;
            }
        });
        List<String> dict = Arrays.asList(words);
        for (int i = dict.size() - 1; i >= 0; i--) {
            String temp = dict.get(i);
            String result = temp;
            while (dict.contains(temp)) {
                if (temp.length() == 1) {
                    return result;
                }
                temp = temp.substring(0, temp.length() - 1);
            }
        }
        return "";
    }
}
