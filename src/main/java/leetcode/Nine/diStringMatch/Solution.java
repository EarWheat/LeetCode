package leetcode.Nine.diStringMatch;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/9 5:12 PM
 * @Version: 1.initial version; 2022/5/9 5:12 PM
 */
public class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int min = 0, max = n;
        int i = 0;
        int[] res = new int[n + 1];
        while (min != max) {
            if (s.charAt(i) == 'I') res[i++] = min++;
            else res[i++] = max--;
        }
        res[i] = min;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.diStringMatch("III")));
    }
}
