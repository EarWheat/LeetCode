package leetcode.Two.Thousand.platesBetweenCandles;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liuzhaolu
 * @description：2055. 蜡烛之间的盘子
 * @prd : https://leetcode-cn.com/problems/plates-between-candles/
 * @date ：2022/3/8 5:26 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/8 5:26 下午     liuzhaolu       firstVersion
 */
public class Solution {
    Map<String, Integer> memory = new HashMap<>();

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = candles(s, queries[i][0], queries[i][1]);
        }
        return res;
    }

    public int candles(String s, int start, int end) {
        boolean startCandles = s.charAt(start) == '|';
        boolean endCandles = s.charAt(start) == '|';
        while (start <= end) {
            if (s.charAt(start) != '|') {
                start++;
            } else {
                startCandles = true;
            }
            if (s.charAt(end) != '|') {
                end--;
            } else {
                endCandles = true;
            }
            if (startCandles && endCandles) {
                break;
            }
        }
        if (start >= end) {
            return 0;
        } else {
            if (memory.containsKey(start + "_" + end)) {
                return memory.get(start + "_" + end);
            }
            int res = 0;
            for (int i = start; i < end; i++) {
                if (s.charAt(i) == '*') {
                    res++;
                }
            }
            memory.put(start + "_" + end, res);
            return res;
        }
    }

    public int[] answer(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}});
    }
}
