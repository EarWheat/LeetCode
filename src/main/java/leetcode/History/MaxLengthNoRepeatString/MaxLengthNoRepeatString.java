package leetcode.History.MaxLengthNoRepeatString;

import java.util.HashMap;
import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-24 21:50
 * @desc:给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @ex:
 * 输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*       pwpkew
 */
public class MaxLengthNoRepeatString {
    public static void main(String[] args){
//        String s = "dvdf"; // 3
//        String s = "aab";  // 2
        String s = "pwwkew"; // 3
        System.out.println(solution(s));
    }

    private static int solution(String s){
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for(int i = 0; i < chars.length; i++){
            if(!map.containsKey(chars[i])){
                map.put(chars[i],i);
            } else {
                maxLength = Math.max(map.size(), maxLength);
                int index = map.get(chars[i]);
                maxLength = Math.max(solution(s.substring(index + 1)), maxLength);
                break;
            }
        }
        maxLength = Math.max(map.size(), maxLength);
        return maxLength;
    }
}
