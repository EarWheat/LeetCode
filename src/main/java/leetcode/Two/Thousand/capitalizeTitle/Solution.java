package leetcode.Two.Thousand.capitalizeTitle;

import java.util.Locale;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2024/3/11 4:24 PM
 * @Version: 1.initial version; 2024/3/11 4:24 PM
 */
public class Solution {
    public String capitalizeTitle(String title) {
        String[] split = title.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.length() <= 2) {
                stringBuilder.append(s.toLowerCase());
            } else {
                stringBuilder.append(s.substring(0,1).toUpperCase()).append(s.substring(1).toLowerCase());
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
