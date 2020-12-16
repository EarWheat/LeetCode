package leetcode.Two.wordPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-16 10:34
 * @desc 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class wordPattern {
    public static boolean wordPattern(String pattern, String s) {
        if(pattern.length() == 0){
            return false;
        }
        String[] word = s.split(" ");
        if(pattern.length() != word.length){
            return false;
        }
        // 用于存储pattern对应的string， a => dog, b => cat
        Map<Character, String> patternMap = new HashMap<>();
        // 用于存储已经对应的string
        Set<String> patternWord = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++){
            if(!patternMap.containsKey(pattern.charAt(i))){
                if(patternWord.contains(word[i])){
                    return false;
                } else {
                    patternWord.add(word[i]);
                }
                patternMap.put(pattern.charAt(i),word[i]);
            } else {
                String temp = patternMap.get(pattern.charAt(i));
                if(!temp.equals(word[i])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
