package leetcode.One.Thousand.beautySum;
//一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
//
//
// 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
//
//
// 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
//
//
//
// 示例 1：
//
//
//输入：s = "aabcb"
//输出：5
//解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
//
// 示例 2：
//
//
//输入：s = "aabcbaa"
//输出：17
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 只包含小写英文字母。
//
// Related Topics 哈希表 字符串 计数 👍 55 👎 0

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/12/12 3:10 PM
 * @Version: 1.initial version; 2022/12/12 3:10 PM
 */
public class Solution {
    public int beautySum(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // 先减去i
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
            for (int j = i + 1; j < s.length(); j++) {
                // 计算最大和最小
                List<Map.Entry<Character, Integer>> collect = map.entrySet().stream().sorted(new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return o1.getValue().compareTo(o2.getValue());
                    }
                }).collect(Collectors.toList());
                Map.Entry<Character, Integer> characterIntegerEntry = collect.get(0);
                Integer min = characterIntegerEntry.getValue();
                Integer max = collect.get(collect.size() - 1).getValue();
                result += max - min;
            }
        }
        return result;
    }

    public int answer(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.beautySum("aabcb"));
    }
}
