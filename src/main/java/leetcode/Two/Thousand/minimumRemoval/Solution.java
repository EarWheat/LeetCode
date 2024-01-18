package leetcode.Two.Thousand.minimumRemoval;

import java.util.Arrays;

/**
 * @Desc: 2171. 拿出最少数目的魔法豆
 * @Author: 泽露
 * @Date: 2024/1/18 5:31 PM
 * @Version: 1.initial version; 2024/1/18 5:31 PM
 */
public class Solution {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long total = 0; // 豆子总数
        for (int i = 0; i < n; i++) {
            total += beans[i];
        }
        long res = total; // 最少需要移除的豆子数
        for (int i = 0; i < n; i++) {
            res = Math.min(res, total - (long) beans[i] * (n - i));
        }
        return res;
    }
}