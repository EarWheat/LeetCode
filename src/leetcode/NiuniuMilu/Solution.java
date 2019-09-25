package leetcode.NiuniuMilu;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-25 17:58
 * @desc:牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。
 * @input:每个输入包含一个测试用例。
每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。
* @output:输出牛牛最后面向的方向，N表示北，S表示南，E表示东，W表示西。
* @ex:3
* LRR
* E
 */
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(getFace(str,n));
    }

    private static char getFace(String str, int n){
        int num = 0;
        for(int i = 0 ; i < n; i++){
            char c = str.charAt(i);
            if(c == 'L'){
                num++;
            }
            if(c == 'R'){
                num--;
            }
        }
        if(num >= 0){
            switch (num % 4){
                case 0:
                    return 'N';
                case 1:
                    return 'W';
                case 2:
                    return 'S';
                case 3:
                    return 'E';
            }
        } else {
            num = num * (-1);
            switch (num%4){
                case 0:
                    return 'N';
                case 1:
                    return 'E';
                case 2:
                    return 'S';
                case 3:
                    return 'W';
            }
        }
        return 'a';
    }
}
