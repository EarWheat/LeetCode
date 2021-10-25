package leetcode.Two.calculate;

import org.apache.commons.lang.StringUtils;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/10 下午5:31
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public static int calculate(String s) {
        if(s.length() == 1){
            return Integer.parseInt(s);
        }
        s = s.replaceAll(" ","");
        int[] temp = calculateKuohao(s);
        if(temp[0] != -1 && temp[1] != -1){
            if(temp[0] == 1 && temp[1] == s.length() - 1){
                return calculateWithOutKuohao(s.substring(temp[0], temp[1]));
            }
            char f;
            String a;
            String b;
            if(temp[0] > 1){
                a = s.substring(0,temp[0] - 2);
                f = s.charAt(temp[0] - 2);
                b = s.substring(temp[0] - 1);
            } else {
                a = s.substring(temp[0],temp[1]);
                f = s.charAt(temp[1] + 1);
                b = s.substring(temp[1] + 2);
            }
            if(f == '+'){
                return calculate(a) + calculate(b);
            } else if(f == '-'){
                return calculate(a) - calculate(b);
            } else if(f == '*'){
                return calculate(a) * calculate(b);
            } else {
                return calculate(a) / calculate(b);
            }
        }
        return calculateWithOutKuohao(s);
    }

    // 没有括号计算
    public static int calculateWithOutKuohao(String s){
        int temp = Integer.parseInt(String.valueOf(s.charAt(0)));
        int index = 1;
        while (index < s.length()){
            if(s.charAt(index) == '+'){
                temp += Integer.parseInt(String.valueOf(s.charAt(index + 1)));
                index += 2;
            } else if(s.charAt(index) == '-'){
                temp -= Integer.parseInt(String.valueOf(s.charAt(index + 1)));
                index += 2;
            }
        }
        return temp;
    }


    // 先计算括号，返回第一个括号内的内容
    public static int[] calculateKuohao(String s){
        Stack stack = new Stack();
        int left = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            // 先算括号
            if (s.charAt(i) == '(') {
                if(stack.empty()){
                    left = i + 1;
                }
                stack.push(s.charAt(i));    // 左括号入栈
            }
            if (s.charAt(i) == ')'){
                stack.pop();    // 左括号出栈
                if(stack.empty()){
                    right = i;
                    break;
                }
            }
        }
        return new int[]{left,right};
    }


    public static void main(String[] args) {
//        System.out.println(calculate("1 + 1"));
//        System.out.println(calculate("2-1 + 2"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
