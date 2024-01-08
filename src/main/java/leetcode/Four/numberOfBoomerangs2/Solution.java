package leetcode.Four.numberOfBoomerangs2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: 回旋镖的数量
 * @Author: 泽露
 * @Date: 2024/1/8 6:21 PM
 * @Version: 1.initial version; 2024/1/8 6:21 PM
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }
}