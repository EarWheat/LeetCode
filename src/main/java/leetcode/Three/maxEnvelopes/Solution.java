package leetcode.Three.maxEnvelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/4 下午5:03
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        // 问题在于怎么通过宽度进行排序了
        int n = envelopes.length;
        // 按宽度进行升序排列，如果宽度一致，则按高度升序排列
        Arrays.sort(envelopes,
                new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return a[0] == b[0] ? a[1] -b[1] : a[0] - b[0];
                    }
                }
        );
        int[] dp = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            int tmp = 1;
            for(int j = i-1; j>=0; j--) {
                if(envelopes[i][0] > envelopes[j][0]
                        && envelopes[i][1] > envelopes[j][1]) {
                    tmp = Math.max(tmp, dp[j] + 1);
                }
            }
            dp[i] = tmp;
            max = Math.max(tmp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        Solution solution = new Solution();
        System.out.println(solution.maxEnvelopes(envelopes));
    }
}
