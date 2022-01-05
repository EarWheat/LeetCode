package leetcode.One.Thousand.modifyString;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：1576. 替换所有的问号
 * @prd : https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 * @date ：2022/1/5 10:21 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/5 10:21 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public String modifyString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '?'){
                int end = i;
                while (end < s.length() && s.charAt(end) == '?'){
                    end++;
                }
                if(i >= 1){
                    if(end >= s.length()){
                        stringBuilder.replace(i, end, replaceString(s.charAt(i - 1), '?', end - i));
                    } else {
                        stringBuilder.replace(i, end, replaceString(s.charAt(i - 1), s.charAt(end), end - i));
                    }
                    i = end;
                } else {
                    if(end >= s.length()){
                        stringBuilder.replace(i, end, replaceString('?', '?', end - i));
                    } else {
                        stringBuilder.replace(i, end, replaceString('?', s.charAt(end), end - i));
                    }
                    i = end;
                }
            }
        }
        return stringBuilder.toString();
    }

    public String replaceString(char start, char end, int length){
        StringBuilder stringBuilder = new StringBuilder();
        char temp = 'a';
        int i = 0;
        while (i != length){
            if(temp != start && temp != end){
                stringBuilder.append(temp);
                i++;
            }
            temp++;
            if(temp > 'z'){
                temp = 'a';
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.modifyString("??yw?ipkj?"));
    }
}
