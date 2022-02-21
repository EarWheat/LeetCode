package leetcode.Eight.pushDominoes;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：838. 推多米诺
 * @prd : https://leetcode-cn.com/problems/push-dominoes/
 * @date ：2022/2/21 3:42 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/21 3:42 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public String pushDominoes(String dominoes) {
        int[] power = new int[dominoes.length()]; // 力  //-1：力向左，1：力向右
        while (true) {
            for (int i = 0; i < dominoes.length() - 1; i++) {
                // 看下一张牌
                if (dominoes.charAt(i) == '.') {
                    char next = dominoes.charAt(i + 1);
                    if (next == 'L') {
                        power[i]--;
                    }
                }
                if (dominoes.charAt(i) == 'R' && i < dominoes.length() - 1) {
                    power[i + 1]++;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < dominoes.length(); i++) {
                if (dominoes.charAt(i) == '.') {
                    if (power[i] == -1) {
                        stringBuilder.append('L');
                    }
                    if (power[i] == 1) {
                        stringBuilder.append('R');
                    }
                    if (power[i] == 0) {
                        stringBuilder.append('.');
                    }
                } else {
                    stringBuilder.append(dominoes.charAt(i));
                }
            }
            if (stringBuilder.toString().equalsIgnoreCase(dominoes)) {
                break;
            }
            dominoes = stringBuilder.toString();
        }
        return dominoes;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pushDominoes("RR.L"));
    }
}
