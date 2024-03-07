package leetcode.Two.Thousand.divisibilityArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc: 2575. 找出字符串的可整除数组
 * @Author: 泽露
 * @Date: 2024/3/7 4:36 PM
 * @Version: 1.initial version; 2024/3/7 4:36 PM
 */
public class Solution {
    public int[] divisibilityArray(String word, int m) {
        int left = 0;
        int right = 1;
        int[] dev = new int[word.length()];
        while (right <= word.length()) {
            Long num = Long.parseLong(word.substring(left, right));
            if (num % m == 0) {
                left = right;
                dev[left - 1] = 1;
            }
            right++;
        }
        return dev;
    }

    public int[] divisibilityArray2(String word, int m) {
        int[] res = new int[word.length()];
        long cur = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur = (cur * 10 + (c - '0')) % m;
            res[i] = (cur == 0) ? 1 : 0;
        }
        return res;
    }

}
