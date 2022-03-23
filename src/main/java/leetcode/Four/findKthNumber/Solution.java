package leetcode.Four.findKthNumber;

import java.util.PriorityQueue;

/**
 * @author ：liuzhaolu
 * @description：440. 字典序的第K小数字
 * @prd : https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 * @date ：2022/3/23 2:05 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/23 2:05 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int findKthNumber(int n, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
            String sa = String.valueOf(a);
            String sb = String.valueOf(b);
            for (int i = 0; i < Math.min(sa.length(), sb.length()); i++) {
                if (sa.charAt(i) < sb.charAt(i)) {
                    return -1;
                } else if (sa.charAt(i) > sb.charAt(i)) {
                    return 1;
                }
            }
            return Integer.compare(sa.length(), sb.length());
        });
        for (int i = 1; i <= n; i++) {
            priorityQueue.offer(i);
        }
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }
        int res = priorityQueue.poll();
        return res;
    }
}
