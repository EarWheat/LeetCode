package leetcode.History.SetLamp;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-24 18:10
 * @desc:小Q正在给一条长度为n的道路设计路灯安置方案。

为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。

小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。

小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。
* 输入的第一行包含一个正整数t(1 <= t <= 1000), 表示测试用例数
接下来每两行一个测试数据, 第一行一个正整数n(1 <= n <= 1000),表示道路的长度。
第二行一个字符串s表示道路的构造,只包含'.'和'X'。
* 对于每个测试用例, 输出一个正整数表示最少需要多少盏路灯。
* 示例
* 2
3
.X.
11
...XX....XX
 */
//贪心算法求解：1.当遇到第一个'.'时，表示该位置需要被照亮，此时不安装路灯，在它的下一个位置安装路灯，即sum+1;
//因为该路灯位置的下一个位置已经被照亮了，因此下标+2
//遇到‘X’时跳过，因为不需要安装
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            String s = sc.next();
            int sum = 0;
            for(int j = 0; j < n; j++){
                if(s.charAt(j) == '.'){
                    sum++;
                    j = j + 2;
                }
            }
            System.out.println(sum);
        }
    }
}
