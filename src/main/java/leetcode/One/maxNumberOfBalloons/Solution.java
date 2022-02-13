package leetcode.One.maxNumberOfBalloons;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liuzhaolu
 * @description：1189. “气球” 的最大数量
 * @prd : https://leetcode-cn.com/problems/maximum-number-of-balloons/
 * @date ：2022/2/13 2:30 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/13 2:30 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }
        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0);
        int o = map.getOrDefault('o', 0);
        int n = map.getOrDefault('n', 0);
        return Math.min(b, Math.min(a, Math.min(n, Math.min(l / 2, o / 2))));
    }
}
