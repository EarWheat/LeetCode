package leetcode.decodeString;

import java.util.Stack;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-28 16:22
 * @desc:
 * 给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".

* 思路用栈来实现，遇到"]"就出栈返回
 */
public class decodeString {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> decodeStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ']'){
                stack.push(s.charAt(i));
            } else {
                char decode = stack.pop();
                // 需要解码的字符串
                while (decode != '['){
                    // 存入需要解码的字符串
                    decodeStack.push(decode);
                    decode = stack.pop();
                }
                // pop掉'['
                decode = stack.pop();
                // 重复K次
                StringBuilder k = new StringBuilder();
                while (!isChar(decode)){
                    if(decode == '['){
                        stack.push(decode);
                        break;
                    }
                    k.append(decode);
                    if(stack.empty()){
                        break;
                    } else {
                        decode = stack.pop();
                        if(!isChar(decode)){
                            continue;
                        } else {
                            stack.push(decode);
                        }
                    }
                }
                int reK = Integer.parseInt(k.reverse().toString());
                String result = getDecodeStr(decodeStack,reK);
                char[] charArray = result.toCharArray();
                for(char c : charArray) stack.push(c);
            }
        }
        return formatStackOut(stack);
    }

    private static String getDecodeStr(Stack<Character> stack, int K){
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        String result = "";
        for(int i =0; i < K; i++){
            result += stringBuilder.toString();
        }
        return result;
    }

    private static boolean isChar(char c){
        if((c >= 'a' && c <= 'z') || ( c >= 'A' && c <= 'Z')){
            return true;
        } else {
            return false;
        }
    }

    private static String formatStackOut(Stack<Character> stack){
        StringBuilder result = new StringBuilder();
        while (!stack.empty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("100[leetcode]"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
