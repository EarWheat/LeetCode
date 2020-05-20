package leetcode.findTheLongestSubstring;

import UtilClass.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-20 21:00
 * @desc:给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。

 

示例 1：

输入：s = "eleetminicoworoep"
输出：13
解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
示例 2：
* ltmncwrop

输入：s = "leetcodeisgreat"
输出：5
解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
示例 3：

输入：s = "bcbcbc"
输出：6
解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。

* 思路：用Set存储每个字符，如果元音字符存在set中，则剔除，若最后set不包含元音，若包含元音字母，则记录剩余元音字母的index;
 */
public class findTheLongestSubstring {

    static char[] yuanyin = {'a','e','i','o','u'};

    public int findTheLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>(); // <e, 0>, <l, 1>, <e, 2>
        for(int i = 0; i < chars.length; i++){
            if(map.containsKey(chars[i])){
                if(isYuanyin(chars[i])){
                    map.remove(chars[i]);
                }
            } else {
                map.put(chars[i], i);
            }
        }
    }

    private static boolean isYuanyin(char c){
        char[] yuanyin = {'a','e','i','o','u'};
        for (char i: yuanyin){
            if(i == c){
                return true;
            }
        }
        return false;
    }

}
