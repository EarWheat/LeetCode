package leetcode.LongestPalindrome;

import java.util.ArrayList;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-05 08:50
 * @desc:判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

 */
public class isPalindrome {

    public static void main(String[] args) {
        int x = 10;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        int temp = x;
        if(x < 0){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (temp >= 10){
            list.add(temp % 10);
            temp = temp / 10;
        }
        list.add(temp);
        int y = 0;
        for (Integer integer : list) {
            y = y * 10 + integer;
        }
        return x == y;
    }
}
