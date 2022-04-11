package leetcode.Eight.uniqueMorseRepresentations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：liuzhaolu
 * @description：804. 唯一摩尔斯密码词
 * @prd : https://leetcode-cn.com/problems/unique-morse-code-words/
 * @date ：2022/4/10 10:14 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/10 10:14 上午     liuzhaolu       firstVersion
 */
public class Solution {
    String[] morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> wordSet = new HashSet<>();
        Arrays.stream(words).forEach(word -> {
            wordSet.add(morseString(word));
        });
        return wordSet.size();
    }

    public String morseString(String word) {
        StringBuilder res = new StringBuilder();
        for (Character c : word.toCharArray()) {
            res.append(morse[c - 'a']);
        }
        return res.toString();
    }
}
