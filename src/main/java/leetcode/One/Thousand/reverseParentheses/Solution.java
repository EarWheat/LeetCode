package leetcode.One.Thousand.reverseParentheses;

import java.util.Stack;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/26 下午2:32
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public String reverseParentheses(String s) {
        // ((ab(cd)e)h)
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = 0;
        int index = 0;
        while (index < s.length()){
            if(s.charAt(index) == ')'){
                right = index;
                if(!stack.isEmpty()){
                    left = stack.pop();
                    StringBuilder stringBuilder = new StringBuilder();
                    StringBuilder reverseString = new StringBuilder(s.substring(left + 1,right));
                    stringBuilder.append(s.substring(0,left));
                    stringBuilder.append(reverseString.reverse());
                    stringBuilder.append(s.substring(right + 1, s.length()));
                    return reverseParentheses(stringBuilder.toString());
                }
            }
            if(s.charAt(index) == '('){
                stack.push(index);
            }
            index++;
        }
        return s;
    }

    public static void main(String[] args) {
        String str = "a(bcdefghijkl(mno)p)q";
        Solution solution = new Solution();
        System.out.println(solution.reverseParentheses(str));
    }
}
