package leetcode.History.MaxResult;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-08 15:32
 * @desc:今天上课，老师教了小易怎么计算加法和乘法，乘法的优先级大于加法，但是如果一个运算加了括号，那么它的优先级是最高的。
 * 现在小易希望你帮他计算给定3个数a，b，c，在它们中间添加"+"， "*"， "("， ")"符号，能够获得的最大值。
 * @input:
 * 一行三个数a，b，c (1 <= a, b, c <= 10)
 * @output:
 * 能够获得的最大值
 * @ex:
 * 1 2 3
 * 9
 */
public class MaxResult {
    public static void main(String[] args){
//        // 按n个数求最大值结果计算
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int max = a;
//        // 输入-1结束
//        while (!scanner.hasNext("-1")){
//            int next = scanner.nextInt();
//            // 证明ab之中含有1
//            if(max + next > max * next){
//                max = max + next;
//            } else {
//                max = max * next;
//            }
//        }
//        System.out.println(max);
        System.out.println(maxThree());
    }

    public static int maxThree(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int max = a;
        // 证明ab之中含有1
        if(a + b > a * b){
            max = max + b;
        } else {
            max = max * b;
        }
        int c = scanner.nextInt();
        // 证明ab之中含有1
        if(max + c > max * c){
            max = max + c;
        } else {
            max = max * c;
        }
        return max;
    }
}
