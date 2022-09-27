package Interview.CheckPermutation;
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1：
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true
//
//
// 示例 2：
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
//
//
// 说明：
//
//
// 0 <= len(s1) <= 100
// 0 <= len(s2) <= 100
//
// Related Topics 哈希表 字符串 排序 👍 120 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/9/27 5:29 PM
 * @Version: 1.initial version; 2022/9/27 5:29 PM
 */
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            charMap.put(s1.charAt(i), charMap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (charMap.containsKey(s2.charAt(i))) {
                if (charMap.get(s2.charAt(i)) == 1) {
                    charMap.remove(s2.charAt(i));
                } else {
                    charMap.put(s2.charAt(i), charMap.get(s2.charAt(i)) - 1);
                }
            }
        }
        return charMap.isEmpty();
    }
}
