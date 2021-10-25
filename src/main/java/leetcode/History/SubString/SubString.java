package leetcode.History.SubString;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-18 18:00
 * @desc:
 */
public class SubString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int[] result = subString(s,t);
        for(int i =0; i < result.length;i++){
            System.out.println(result[i]);
        }
    }

    private static int[] subString(String s, String t){
        int lengthS = s.length();
        int lengthT = t.length();
        int[] result = new int[lengthS];
        // 前小于T字段
        for(int i = 0; i < lengthT - 1; i++){
            result[i] = 0;
        }
        // T相等
        if(s.substring(0,lengthT-1).equals(t)){
            result[lengthT - 1] = 1;
        } else {
            result[lengthT - 1] = 0;
        }
        // S大于T
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        boolean isSame = false;
        for(int i = lengthT; i < lengthS; i++){
            // 从T+1开始匹配char
            if(s_char[i] == t_char[i]){
                isSame = true;
            } else {
                result[i] = result[i-1];
                isSame = false;
            }
            // 匹配到最后一个+1
            if(isSame && s_char[i] == t_char[lengthT-1]){
                result[i] = result[i-1] + 1;
            }
        }
        return result;
    }
}
