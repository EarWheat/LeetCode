package leetcode.One.Thousand.removeOuterParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/28 10:34 AM
 * @Version: 1.initial version; 2022/5/28 10:34 AM
 */
public class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        List<String> subString = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
                stringBuilder.append('(');
            } else if(s.charAt(i) == ')'){
                stringBuilder.append(')');
                stack.pop();
                if(stack.isEmpty()){
                    subString.add(stringBuilder.substring(1, stringBuilder.length() - 1));
                    stringBuilder.delete(0, stringBuilder.length());
                }
            }
        }
        StringBuilder result = new StringBuilder();
        subString.forEach(result::append);
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeOuterParentheses("(()())(())"));
    }
}
