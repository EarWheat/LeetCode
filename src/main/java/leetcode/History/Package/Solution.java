package leetcode.History.Package;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2019-10-14 19:43
 * @desc:牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
 * @input:
 * 输入包括两行
第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
 * @output:
 * 输出一个正整数, 表示牛牛一共有多少种零食放法。
 * @example:
 * 3 10
 * 1 2 4
 *
 * 8
 */

//思路：背包问题相当于所有物品的0，1全排列。用0和1去排列全部物品，若排列的重量大于背包容量，则该排列失效否则排列有效。
public class Solution {


    // 计算容量
    private int calculateWeight(int[] array){
        int weight = 0;
        for(int i = 0 ; i < array.length; i++){

        }
        return weight;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        int temp = 0;
        // 有足够多的
        // 背包容量不满时
        while (temp <= w){
            for(int i = 0;i < n ; i++){
                temp += array[i];
            }
        }
    }
}
