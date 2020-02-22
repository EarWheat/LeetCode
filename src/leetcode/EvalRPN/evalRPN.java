package leetcode.EvalRPN;

import java.util.Stack;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-22 15:36
 * @desc:计算逆波兰式（后缀表达式）的值
运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
* @["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9↵  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class evalRPN {
    public static void main(String[] args){
        String[] tokens = new String[]{"3","-4","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") ||
                tokens[i].equals("-") ||
                tokens[i].equals("*") ||
                tokens[i].equals("/")){
                int m = Integer.parseInt(stack.pop());
                int n = Integer.parseInt(stack.pop());
                int result;
                switch (tokens[i]){
                    case "+":
                        result = n + m;
                        break;
                    case "-":
                        result = n - m;
                        break;
                    case "*":
                        result = n * m;
                        break;
                    case "/":
                        result = n / m;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + tokens[i]);
                }
                stack.push(String.valueOf(result));
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
