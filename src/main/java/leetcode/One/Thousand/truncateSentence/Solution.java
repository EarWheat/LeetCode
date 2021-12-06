package leetcode.One.Thousand.truncateSentence;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/12/6 3:59 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/6 3:59 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(words[i]).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1).toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.truncateSentence("What is the solution to this problem",4));
    }

}
