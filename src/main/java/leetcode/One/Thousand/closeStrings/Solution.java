package leetcode.One.Thousand.closeStrings;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/11/30 5:04 PM
 * @Version: 1.initial version; 2023/11/30 5:04 PM
 */
public class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] count1 = new int[26], count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0 && count2[i] == 0 || count1[i] == 0 && count2[i] > 0) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }
}