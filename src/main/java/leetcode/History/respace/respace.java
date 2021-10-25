package leetcode.History.respace;

import java.util.Arrays;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-09 15:28
 * @desc:
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。

注意：本题相对原题稍作改动，只需返回未识别的字符数

 

示例：

输入：
dictionary = ["looked","just","like","her","brother"]
sentence = "jesslookedjustliketimherbrother"
输出： 7
解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。

*
* 思路：
* 动态规划
* 定义 dp[i] 表示考虑前 i 个字符最少的未识别的字符数量，从前往后计算dp 值。

考虑转移方程，每次转移的时候我们考虑第 j(j≤i) 个到第 i 个字符组成的子串 sentence[j−1⋯i−1] （注意字符串下标从 0 开始）是否能在词典中找到，如果能找到的话按照定义转移方程即为

dp[i]=min(dp[i],dp[j−1])

否则没有找到的话我们可以复用 dp[i−1] 的状态再加上当前未被识别的第 i 个字符，因此此时 dp 值为

dp[i]=dp[i−1]+1


 */
public class respace {
    public static int respace(String[] dictionary, String sentence) {
        int[] dp = new int[sentence.length() + 1];
        for(int i = 1; i <= sentence.length(); i++){
            for(int j = 1; j <= i; j++){
                String temp = sentence.substring(j - 1,i);
                if(isWorld(dictionary, temp)){
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                    break;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        }
        return dp[dp.length - 1];
    }

    private static boolean isWorld(String[] dictionary, String s){
        List<String> list = Arrays.asList(dictionary);
        return list.contains(s);
    }

    public static void main(String[] args) {
        String[] dictionary = new String[]{"looked","just","like","her","brother"};
        System.out.println(respace(dictionary, "jesslookedjustliketimherbrother"));
    }
}
