package leetcode.Four.findSubstringInWraproundString;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc: 467. 环绕字符串中唯一的子字符串
 * @Author: 泽露
 * @Date: 2022/5/25 3:39 PM
 * @Version: 1.initial version; 2022/5/25 3:39 PM
 */
public class Solution {
    public int findSubstringInWraproundString(String p) {
        int result = 0;
        Set<String> subStrSet = new HashSet<>();
        if (p.length() == 1) {
            return 1;
        }
        for (int i = 1; i <= p.length(); i++) {
            for (int j = 0; j <= p.length() - i; j++) {
                String subString = p.substring(j, j + i);
                if (!subStrSet.contains(subString) && isMatch(subString)) {
                    result++;
                    subStrSet.add(subString);
                }
            }
        }
        return result;
    }

    public boolean isMatch(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == 'z'){
                if(s.charAt(i + 1) != 'a'){
                    return false;
                }
            } else {
                if(s.charAt(i + 1) - s.charAt(i) != 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstringInWraproundString("zaba"));
    }
}
