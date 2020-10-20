package leetcode.History.Unzip;

import java.util.Scanner;
import java.util.Stack;


/*
 * @author:liuzhaolu
 * @createTime: 2020-02-02 10:31
 * @desc:小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 * @input:输入第一行包含一个字符串s，代表压缩后的字符串。
S的长度<=1000;
S仅包含大写字母、[、]、|;
解压后的字符串长度不超过100000;
压缩递归层数不超过10层;
 * @output: 输出一个字符串，代表解压后的字符串。
 * @ex:
 * in:HG[3|B[2|CA]]F
 * out:HGBCACABCACABCACAF
 */
public class Unzip {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while (s.contains("|")){
            s = Unzip(s);
        }
        System.out.println(s);
    }

    private static String Unzip(String s){
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer resultStr = new StringBuffer(s);
        char[] chars = s.toCharArray();
        // 栈用于匹配括号
        Stack<Character> stack = new Stack<>();
        // end：解压结束位置,size：括号中内容长度
        int size = 0;
        int end = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ']'){
                end = i;
                char out = stack.pop();
                size += 1;
                while (out != '['){
                    stringBuffer.append(out);
                    out = stack.pop();
                    size++;
                }
                break;
            }
            stack.push(chars[i]);
        }
        String subStr = stringBuffer.reverse().toString();
        resultStr.replace(end - size, end + 1 , parseStr(subStr));
        return resultStr.toString();
    }

    private static String parseStr(String s){
        StringBuffer stringBuffer = new StringBuffer();
        if(!s.contains("|")){
            return "";
        }
        String[] strings = s.split("\\|");
        int temp = Integer.parseInt(strings[0]);
        for(int i = 0 ;i < temp; i++){
            stringBuffer.append(strings[1]);
        }
        return stringBuffer.toString();
    }
}
