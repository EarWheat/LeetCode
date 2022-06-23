package leetcode.One.Thousand.minOperationsStr;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/23 5:58 PM
 * @Version: 1.initial version; 2022/6/23 5:58 PM
 */
public class Solution {
    public int minOperations(String s) {
        return Math.min(startWith0(s), startWith1(s));
    }

    public int startWith0(String s){
        int result = 0;
        if(s.charAt(0) != '0'){
            result++;
        }
        char temp = '0';
        int i = 1;
        while (i < s.length()){
            if(s.charAt(i) == temp){
                temp = temp == '0' ? '1' : '0';
                result++;
            } else {
                temp = s.charAt(i);
            }
            i++;
        }
        return result;
    }

    public int startWith1(String s){
        int result = 0;
        if(s.charAt(0) != '1'){
            result++;
        }
        char temp = '1';
        int i = 1;
        while (i < s.length()){
            if(s.charAt(i) == temp){
                temp = temp == '0' ? '1' : '0';
                result++;
            } else {
                temp = s.charAt(i);
            }
            i++;
        }
        return result;
    }
}
