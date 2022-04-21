package leetcode.Eight.toGoatLatin;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：824. 山羊拉丁文
 * @prd : https://leetcode-cn.com/problems/goat-latin/
 * @date ：2022/4/21 9:26 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/21 9:26 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public String toGoatLatin(String sentence) {
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        String vowel = "aeiouAEIOU";
        for (int i = 0; i < strs.length; i++) {
            sb.append(vowel.indexOf(strs[i].charAt(0)) == -1 ? strs[i].substring(1) + strs[i].charAt(0) + "ma"
                    : strs[i] + "ma");
            for (int j = 0; j < i + 1; j++)
                sb.append('a');
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}
