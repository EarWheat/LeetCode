package leetcode.isValid;

import java.util.Stack;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-12 10:55
 * @desc:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

 */
public class isValid {
    /**
     * 入栈，遇到右括号出栈，若栈顶元素不匹配就为false
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')'){
                if(stack.size() == 0){
                    return false;
                }
                if(stack.pop() != '('){
                    return false;
                }
            }
            if(s.charAt(i) == ']'){
                if(stack.size() == 0){
                    return false;
                }
                if(stack.pop() != '['){
                    return false;
                }
            }
            if(s.charAt(i) == '}'){
                if(stack.size() == 0){
                    return false;
                }
                if(stack.pop() != '{'){
                    return false;
                }
            }
        }
        if(stack.size() == 0){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("["));
    }
}
