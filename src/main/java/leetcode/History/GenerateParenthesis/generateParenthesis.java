package leetcode.History.GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-09 14:32
 * @desc:数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

 */
public class generateParenthesis {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for(String s : list){
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // 用0，1表示'('和')',00001    -> (((()
        //11,1111 -> ((((((
        int p = (int) Math.pow(2, n * 2 - 1);   // 需要用5位2进制表示5个括号。
        for(int i  = 0; i < p; i++){
            String kh = "(" + kuohua(i,n * 2 -1);
            if(isEffect(kh)){
                result.add(kh);
            }
        }
        return result;
    }

    private static boolean isEffect(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else {
                if(stack.size() != 0){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    private static String kuohua(int n, int m){
        // 1011    n = 11;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < m; i++){
            if((n & 1) == 1){
                stringBuilder.append(")");
            } else {
                stringBuilder.append("(");
            }
            n = n >> 1;
        }
        return stringBuilder.reverse().toString();
    }
}
