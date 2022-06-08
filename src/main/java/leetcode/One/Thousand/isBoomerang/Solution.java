package leetcode.One.Thousand.isBoomerang;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Desc: https://leetcode.cn/problems/valid-boomerang/
 * @Author: 泽露
 * @Date: 2022/6/8 4:58 PM
 * @Version: 1.initial version; 2022/6/8 4:58 PM
 */
public class Solution {
    //[[1,0],[1,2],[0,1]]
    public boolean isBoomerang(int[][] points) {
        Set<Double> sets = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            double k = 0;
            if (i + 1 >= points.length) {
                if (points[i][0] == points[0][0] && points[i][1] == points[0][1]) {
                    return false;
                }
                k = getK(points[i], points[0]);
            } else {
                if (points[i][0] == points[i + 1][0] && points[i][1] == points[i + 1][1]) {
                    return false;
                }
                k = getK(points[i], points[i + 1]);
            }
            sets.add(k);
        }
        return sets.size() >= 2;
    }

    public double getK(int[] a, int[] b) {
        if (a[1] == b[1]) {
            return 0;
        }
        if (a[0] == b[0]) {
            return Integer.MAX_VALUE;
        }
        double i = (double) Math.abs(a[1] - b[1]) / (double) Math.abs(a[0] - b[0]);
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isBoomerang(new int[][]{{52,86},{12,65},{24,71}}));
    }
}
