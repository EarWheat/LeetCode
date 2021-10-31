package leetcode.Five.findWords;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @date ：2021/10/31 7:04 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/10/31      liuzhaolu       firstVersion
 */
public class Solution {
    public static String[] model = new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.stream(words).forEach(word -> {
            if(isMatch(StringUtils.lowerCase(word))){
                result.add(word);
            }
        });
        return result.toArray(new String[0]);
    }

    public boolean isMatch(String s){
        for (int i = 0; i < 3; i++) {
            String temp = model[i];
            if(temp.contains(s.substring(0,1))){
                for (int j = 0; j < s.length(); j++) {
                    if(!temp.contains(String.valueOf(s.charAt(j)))){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
