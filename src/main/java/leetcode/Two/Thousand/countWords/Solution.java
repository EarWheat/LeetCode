package leetcode.Two.Thousand.countWords;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: 2085. 统计出现过一次的公共字符串
 * @Author: 泽露
 * @Date: 2024/1/12 4:26 PM
 * @Version: 1.initial version; 2024/1/12 4:26 PM
 */
public class Solution {
    public int countWords(String[] words1, String[] words2) {
        // 统计字符串出现频率
        Map<String, Integer> freq1 = new HashMap<>();
        Map<String, Integer> freq2 = new HashMap<>();
        for (String w : words1) {
            freq1.put(w, freq1.getOrDefault(w, 0) + 1);
        }
        for (String w : words2) {
            freq2.put(w, freq2.getOrDefault(w, 0) + 1);
        }

        // 遍历 words1 出现的字符并判断是否满足要求
        int res = 0;
        for (String w : freq1.keySet()) {
            if (freq1.get(w) == 1 && freq2.getOrDefault(w, 0) == 1) {
                res++;
            }
        }
        return res;
    }
}
