package leetcode.longestCommonPrefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-15 09:49
 * @desc:编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

 */
public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length < 1){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String firstWord = strs[0];
        String secondWord = strs[1];
        int length = Math.min(firstWord.length(), secondWord.length());
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(firstWord.charAt(i) == secondWord.charAt(i)){
                stringBuilder.append(firstWord.charAt(i));
            } else {
                break;
            }
        }
        strs[1] = stringBuilder.toString();
        strs = Arrays.copyOfRange(strs,1,strs.length);
        return longestCommonPrefix(strs);
    }


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
