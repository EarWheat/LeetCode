package leetcode.One.commonChars;

import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-14 10:18
 * @desc 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class commonChars {
    public static List<String> commonChars(String[] A) {
        if(A.length == 0){
            return new ArrayList<>();
        }
        if(A.length == 1){
            return Arrays.asList(A[0].split(""));
        }
        String temp = A[0];
        for(int i = 1; i < A.length; i++){
            temp = sameChars(new StringBuffer(temp), new StringBuffer(A[i]));
        }
        if(temp.length() == 0){
            return new ArrayList<>();
        }
        return Arrays.asList(temp.split(""));
    }

    public static String sameChars(StringBuffer a, StringBuffer b){
        if(a.length() == 0){
            return "";
        }
        StringBuffer result = new StringBuffer();
        int i = 0;
        for(i = 0; i < b.length(); i++){
            if(a.charAt(0) == b.charAt(i)){
                result.append(a.charAt(0));
                break;
            }
        }
        if(i == b.length()){
            result.append(sameChars(a.deleteCharAt(0),b));
        } else {
            result.append(sameChars(a.deleteCharAt(0),b.deleteCharAt(i)));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] result = sameChars(new StringBuffer("ccdd"),new StringBuffer("addbadb")).split("");
        System.out.println(Arrays.asList(result).toString());
        String[] test = new String[]{"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
        System.out.println(commonChars(test));
    }
}
