package leetcode.One.Thousand.checkIfPangram;
//全字母句 指包含英语字母表中每个字母至少一次的句子。
//
// 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
//
// 如果是，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
//输出：true
//解释：sentence 包含英语字母表中每个字母至少一次。
//
//
// 示例 2：
//
//
//输入：sentence = "leetcode"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= sentence.length <= 1000
// sentence 由小写英语字母组成
//
// Related Topics 哈希表 字符串 👍 56 👎 0

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/12/13 7:35 PM
 * @Version: 1.initial version; 2022/12/13 7:35 PM
 */
public class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> sets = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            sets.add(sentence.charAt(i));
        }
        return sets.size() == 26;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
