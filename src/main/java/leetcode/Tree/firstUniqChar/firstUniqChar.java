package leetcode.Tree.firstUniqChar;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-23 10:48
 * @desc 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class firstUniqChar {
    public int firstUniqChar(String s) {
        if(s.length() < 1){
            return -1;
        }
        if(s.length() == 1){
            return 0;
        }
        // 顺序存储字符char的index及次数
        LinkedHashMap<Character, int[]> map = new LinkedHashMap<>();
        int[] temp;
        for(int i = 0; i < s.length(); i++){
            char key = s.charAt(i);
            if(map.containsKey(key)){
                temp = map.get(key);
                temp[0] = temp[0] + 1;
                map.put(key,temp);
            } else {
                temp = new int[2];
                temp[0] = 1;
                temp[1] = i;
                map.put(key,temp);
            }
        }

        for(Map.Entry entry : map.entrySet()){
            temp = (int[]) entry.getValue();
            if(temp[0] == 1){
                return temp[1];
            }
        }
        return -1;
    }
}
