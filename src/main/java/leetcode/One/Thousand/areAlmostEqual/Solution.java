package leetcode.One.Thousand.areAlmostEqual;
//给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
//
// 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
// 输入：s1 = "bank", s2 = "kanb"
//输出：true
//解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
//
//
// 示例 2：
//
// 输入：s1 = "attack", s2 = "defend"
//输出：false
//解释：一次字符串交换无法使两个字符串相等
//
//
// 示例 3：
//
// 输入：s1 = "kelb", s2 = "kelb"
//输出：true
//解释：两个字符串已经相等，所以不需要进行字符串交换
//
//
// 示例 4：
//
// 输入：s1 = "abcd", s2 = "dcba"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s1.length, s2.length <= 100
// s1.length == s2.length
// s1 和 s2 仅由小写英文字母组成
//
// Related Topics 哈希表 字符串 计数 👍 59 👎 0

import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/10/11 11:13 AM
 * @Version: 1.initial version; 2022/10/11 11:13 AM
 */
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        int[] diffIndex = new int[2];
        int diffnum = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                if(diffnum >= 2){
                    return false;
                }
                diffIndex[diffnum++] = i;
            }
        }
        swap(char2, diffIndex[0], diffIndex[1]);
        return Arrays.toString(char1).equals(Arrays.toString(char2));
    }

    public void swap(char[] char2, int i, int j){
        char temp = char2[j];
        char2[j] = char2[i];
        char2[i] = temp;
    }
}
