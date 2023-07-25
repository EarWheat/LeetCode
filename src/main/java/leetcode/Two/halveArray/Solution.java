package leetcode.Two.halveArray;

import java.util.PriorityQueue;

/**
 * @Desc: 将数组和减半的最少操作次数
 * @Author: 泽露
 * @Date: 2023/7/25 2:45 PM
 * @Version: 1.initial version; 2023/7/25 2:45 PM
 */
public class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>((a, b) -> b.compareTo(a));
        for (int num : nums) {
            pq.offer((double) num);
        }
        int res = 0;
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double sum2 = 0.0;
        while (sum2 < sum / 2) {
            double x = pq.poll();
            sum2 += x / 2;
            pq.offer(x / 2);
            res++;
        }
        return res;
    }
}
