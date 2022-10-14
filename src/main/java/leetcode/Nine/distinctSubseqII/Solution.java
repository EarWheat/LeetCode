package leetcode.Nine.distinctSubseqII;
//给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
//
// 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
//
//
// 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
//
//
//
//
// 示例 1：
//
//
//输入：s = "abc"
//输出：7
//解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
//
//
// 示例 2：
//
//
//输入：s = "aba"
//输出：6
//解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
//
//
// 示例 3：
//
//
//输入：s = "aaa"
//输出：3
//解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 2000
// s 仅由小写英文字母组成
//
//
//
// Related Topics 字符串 动态规划 👍 214 👎 0

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/10/14 12:02 PM
 * @Version: 1.initial version; 2022/10/14 12:02 PM
 */
public class Solution {
    Set<String> subSet = new HashSet<>();

    public int distinctSubseqII(String s) {
       getSubString(s);
       return subSet.size();
    }

    public void getSubString(String s) {
        // 剪枝
        if (subSet.contains(s)) {
            return;
        }
        if (s.length() == 1) {
            subSet.add(s);
            return;
        }
        // 添加本身
        subSet.add(s);
        for (int i = 0; i < s.length(); i++) {
            getSubString(s.substring(0,i) + s.substring(i +1, s.length()));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.distinctSubseqII("abc"));
        System.out.println(solution.distinctSubseqII("aba"));
//        System.out.println(solution.distinctSubseqII("aaa"));
    }
}
