package leetcode.Nine.reverseOnlyLetters;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：917. 仅仅反转字母
 * @prd : https://leetcode-cn.com/problems/reverse-only-letters/
 * @date ：2022/2/23 11:33 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/23 11:33 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < s.length() && !isValid(chars[start])) start++;
        while (end >=0 && !isValid(chars[end])) end--;
        while (start < end) {
            if (isValid(chars[start]) && isValid(chars[end])){
                swap(chars, start, end);
                start++;
                end--;
            } else if(!isValid(chars[start])){
                start++;
            } else if(!isValid(chars[end])){
                end--;
            }
        }
        return String.valueOf(chars);
    }

    public boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public void swap(char[] chars, int i , int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
