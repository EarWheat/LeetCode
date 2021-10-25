package leetcode.One.Thousand.removeDuplicates;

import java.util.Stack;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/9 下午4:38
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public static String removeDuplicates(String S) {
        Stack stack = new Stack();
        for (int i = 0; i < S.length(); i++) {
            if(stack.empty()){
                stack.push(S.charAt(i));
            } else {
                if((char)stack.peek() == S.charAt(i)){
                    stack.pop();
                } else {
                    stack.push(S.charAt(i));
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
