package leetcode.Four.countSegments;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/7 11:57 上午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int countSegments(String s) {
        int result = 1;
        boolean conSymbol = false;
//        char a = 'a';
//        char z = 'z';
//        char A = 'A';
//        char Z = 'Z';
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if((temp < 'a' || temp > 'z')
                && (temp < 'A' || temp > 'Z')){
                if(!conSymbol){
                    result++;
                }
                conSymbol = true;
            } else {
                conSymbol = false;
            }
        }
        char temp = s.charAt(s.length() - 1);
        if((temp < 'a' || temp > 'z')
                && (temp < 'A' || temp > 'Z')){
            result --;
        }
        temp = s.charAt(0);
        if((temp < 'a' || temp > 'z')
                && (temp < 'A' || temp > 'Z')){
            result --;
        }
        return result;
    }

    public int countSegmentsV2(String s) {
        s = s.trim();
        int result = 1;
        boolean conSymbol = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                if(!conSymbol){
                    result++;
                }
                conSymbol = true;
            } else {
                conSymbol = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSegments("Hello  Hello  "));
    }
}
