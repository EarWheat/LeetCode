package leetcode.minWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-23 14:08
 * @desc:给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。

思路：滑动窗口
 */
public class minWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }

    // ADABECODEBANC
    public static String minWindow(String s, String t) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int i = -1,j = 0;    // 左右节点
        while (j < chars.length){
            // 右节点
            if(contains(chars[j],s)){
                addMapValue(map, chars[j]);
                if(isSubString(map,t)){
                    i++;
                } else {
                    j++;
                }
            } else {
                j++;
            }

            if(contains(chars[i],s)){
                // 去除左节点。
                subMapValue(map,chars[i]);
                if(isSubString(map,t)){ // 去除后仍满足要求，就移动左窗口。
                    continue;
                } else {
                    j++; // 移动右窗口
                }
            }
        }
        // 初始化右节点
        for(j = 0; j < chars.length; j++){
            if(contains(chars[j],s)){
                addMapValue(map, chars[j]);
                if(isSubString(map,t)){
                    break;
                }
            }
        }
        // 左移节点
        for (i = 0; i < j; i++){
            if(contains(chars[i],s)){
                // 去除左节点。
                subMapValue(map,chars[i]);
                if(isSubString(map,t)){ // 去除后仍满足要求，就移动左窗口。
                    continue;
                } else {
                    j++; // 移动右窗口
                }
            }
        }
    }

    // t是否包含字符串
    private static boolean contains(char c, String T){
        char[] chars = T.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == c){
                return true;
            }
        }
        return false;
    }

    // 根据key加value
    private static void addMapValue(Map<Character, Integer> map, char key){
        if(!map.containsKey(key)){
            map.put(key,1);
        } else {
            int value = map.get(key);
            map.put(key, ++value);
        }
    }

    // 根据key减value
    private static void subMapValue(Map<Character, Integer> map, char key){
        int value = map.get(key);
        map.put(key, --value);
    }

    // map是否符合要求
    private static boolean isSubString(Map<Character, Integer> map, String t){
        char[] chars = t.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(!map.containsKey(chars[i]) || map.get(chars[i]) <= 0){
                return false;
            }
        }
        return true;
    }
}
