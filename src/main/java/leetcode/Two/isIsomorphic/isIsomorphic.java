package leetcode.Two.isIsomorphic;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-27 19:37
 * @desc 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class isIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() <= 1 && s.length() == t.length()){
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> valueSets = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(!valueSets.contains(t.charAt(i))){
                    map.put(s.charAt(i),t.charAt(i));
                    valueSets.add(t.charAt(i));
                } else {
                    return false;
                }
            } else {
                if(!map.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}
