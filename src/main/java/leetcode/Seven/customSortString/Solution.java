package leetcode.Seven.customSortString;
//给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
//
// 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x
//也应该出现在 y 之前。
//
// 返回 满足这个性质的 s 的任意排列 。
//
//
//
// 示例 1:
//
//
//输入: order = "cba", s = "abcd"
//输出: "cbad"
//解释:
//“a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
//因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
//
// 示例 2:
//
//
//输入: order = "cbafg", s = "abcd"
//输出: "cbad"
//
//
//
//
// 提示:
//
//
// 1 <= order.length <= 26
// 1 <= s.length <= 200
// order 和 s 由小写英文字母组成
// order 中的所有字符都 不同
//
// Related Topics 哈希表 字符串 排序 👍 136 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/11/13 10:48 AM
 * @Version: 1.initial version; 2022/11/13 10:48 AM
 */
public class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> charOrder = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            charOrder.put(order.charAt(i), order.length() - i);
        }
        char[] chars = s.toCharArray();
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            characters[i] = chars[i];
        }
        Arrays.sort(characters, (a, b) -> {
            if (charOrder.getOrDefault(a, 0) > charOrder.getOrDefault(b, 0)) {
                return -1;
            } else if (charOrder.getOrDefault(a, 0) < charOrder.getOrDefault(b, 0)) {
                return 1;
            }
            return 0;
        });
        StringBuilder result = new StringBuilder();
        Arrays.stream(characters).forEach(result::append);
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.customSortString("cbafg", "abcd"));
    }
}
