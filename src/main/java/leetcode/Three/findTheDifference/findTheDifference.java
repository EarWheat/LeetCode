package leetcode.Three.findTheDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-18 16:11
 * @desc 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字
 *
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class findTheDifference {
    // 在t中找s没有的
    public char findTheDifference(String s, String t) {
        if(s.length() == 0){
            return t.charAt(0);
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i),1);
            }
        }
        for(int i = 0; i < t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                if(map.get(t.charAt(i)) == 0){
                    return t.charAt(i);
                }
                map.put(t.charAt(i),map.get(t.charAt(i)) - 1);
            } else {
                return t.charAt(i);
            }
        }
        return t.charAt(0);
    }
}
