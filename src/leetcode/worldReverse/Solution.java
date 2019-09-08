package leetcode.worldReverse;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-08 16:54
 * @desc:对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
给定一个原字符串A，请返回逆序后的字符串。例，输入"I am a boy!", 输出"boy! a am I"
 */
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = strings.length - 1; i >= 0 ; i--){
            stringBuilder.append(strings[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder.toString());
    }
}
