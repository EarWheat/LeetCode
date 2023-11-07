package leetcode.Two.Thousand.vowelStringsV2;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/11/7 11:07 AM
 * @Version: 1.initial version; 2023/11/7 11:07 AM
 */
public class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowels = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        int ans = 0;
        for (int i = left; i <= right; ++i) {
            String word = words[i];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                ++ans;
            }
        }
        return ans;
    }
}