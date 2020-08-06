package leetcode.palindromePairs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-06 16:18
 * @desc:
 * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。

 

示例 1：

输入：["abcd","dcba","lls","s","sssll"]
输出：[[0,1],[1,0],[3,2],[2,4]]
解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
示例 2：

输入：["bat","tab","cat"]
输出：[[0,1],[1,0]]
解释：可拼接成的回文串为 ["battab","tabbat"]

* 思路：
* 暴力破解
 */
public class palindromePairs {
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<Integer> temp;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < words.length;i++){
            for(int j = 0; j < words.length; j++){
                // 自己不跟自己组合
                if(i != j){
                    if(isPalindrome(words[i].concat(words[j]))){
                        temp = new LinkedList<>();
                        temp.add(i);
                        temp.add(j);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    // 判断是否是回文串
    private static boolean isPalindrome(String s){
        if(s.length() <= 1){
            return true;
        }
        if(s.charAt(0) == s.charAt(s.length() - 1)){
            return isPalindrome(s.substring(1,s.length() - 1));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("b"));
        System.out.println(isPalindrome("aa"));
        String[] words = new String[]{"abcd","dcba","lls","s","sssll"};
        System.out.println(palindromePairs(words));
    }
}
