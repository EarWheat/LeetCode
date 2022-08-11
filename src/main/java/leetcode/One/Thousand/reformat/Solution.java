package leetcode.One.Thousand.reformat;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/11 3:55 PM
 * @Version: 1.initial version; 2022/8/11 3:55 PM
 */
public class Solution {
    public String reformat(String s) {
        List<Character> num = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num.add(s.charAt(i));
            } else {
                chars.add(s.charAt(i));
            }
        }
        if (Math.abs(num.size() - chars.size()) > 1) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        if (chars.size() > num.size()) {
            result.append(chars.get(0));
            for (int i = 0; i < num.size(); i++) {
                result.append(num.get(i)).append(chars.get(i + 1));
            }
        } else if(chars.size() == num.size()){
            // 这里随便插入
            for (int i = 0; i < num.size(); i++) {
                result.append(num.get(i)).append(chars.get(i));
            }
        } else {
            result.append(num.get(0));
            for (int i = 0; i < num.size(); i++) {
                result.append(chars.get(i)).append(num.get(i + 1));
            }
        }
        return result.toString();
    }
}
