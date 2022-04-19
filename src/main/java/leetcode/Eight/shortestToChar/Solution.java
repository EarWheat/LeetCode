package leetcode.Eight.shortestToChar;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：821. 字符的最短距离
 * @prd : https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 * @date ：2022/4/19 2:51 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/19 2:51 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        int indexLeft = 0;
        int indexRight = 0;
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                for (int j = 0; j < i; j++) {
                    res[j] = i - j;
                }
                break;
            }
        }
        indexLeft = i++;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                indexRight = i;
                for (int j = indexLeft; j < indexRight; j++) {
                    res[j] = Math.min(j - indexLeft, indexRight - j);
                }
                indexLeft = i;
            }
        }
        for (i = indexLeft; i < s.length(); i++) {
            res[i] = i - indexLeft;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shortestToChar("aaba", 'b')));
    }
}
