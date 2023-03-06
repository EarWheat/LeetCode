package leetcode.One.Thousand.minimumDeletions;

//给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
//
//你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
//
//请你返回使 s 平衡 的 最少 删除次数。
//
//示例 1：
//
//输入：s = "aababbab"
//输出：2
//解释：你可以选择以下任意一种方案：
//下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
//下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
//示例 2：
//
//输入：s = "bbaaaaabb"
//输出：2
//解释：唯一的最优解是删除最前面两个字符。
//提示：
//
//1 <= s.length <= 105
//s[i] 要么是 'a' 要么是 'b'​ 。​
//Related Topics
//栈
//字符串
//动态规划
//
//👍 93
//👎 0

import java.util.Stack;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/3/6 12:31 PM
 * @Version: 1.initial version; 2023/3/6 12:31 PM
 */
public class Solution {
    public int minimumDeletions(String s) {
        int countB = 0, dp = 0;  // 令dp表示将s[0,i]变平衡最少需要删除的次数
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                dp = Math.min(dp + 1, countB);  // 末尾出现a的时候，2个选择：1、删除这个a，然后将s[0,i-1]变平衡；2、保留这个a，删除前面所有的b
            } else {
                ++countB;  // 出现b的时候，最后面的b不需要删除，dp不变，b的个数加1就好
            }
        }
        return dp;
    }
}
