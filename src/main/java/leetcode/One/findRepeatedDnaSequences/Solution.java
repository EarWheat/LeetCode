package leetcode.One.findRepeatedDnaSequences;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/8 5:19 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 10; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int left = i;
                int right = j;
                while (right < s.length() && s.charAt(left) == s.charAt(right)){
                    left++;
                    right++;
                    if(left - i == 10){
                        break;
                    }
                }
                if(left - i == 10){
                    set.add(s.substring(i,left));
                }
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * set去重，map计数
     * @param s
     * @return
     */
    public List<String> answer(String s){
        int len = s.length();
        if (len < 10) return new ArrayList<>();
        Set<String> res = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= len; i++) {
            String sub = s.substring(i - 10, i);
            if (map.containsKey(sub)) {
                res.add(sub);
            } else {
                map.put(sub, 1);
            }
        }
        return new ArrayList<>(res);
    }
}
