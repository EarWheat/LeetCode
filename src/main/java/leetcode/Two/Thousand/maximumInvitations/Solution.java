package leetcode.Two.Thousand.maximumInvitations;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/11/1 6:40 PM
 * @Version: 1.initial version; 2023/11/1 6:40 PM
 */
public class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        // 统计入度，便于进行拓扑排序
        int[] indeg = new int[n];
        for (int i = 0; i < n; ++i) {
            ++indeg[favorite[i]];
        }
        boolean[] used = new boolean[n];
        int[] f = new int[n];
        Arrays.fill(f, 1);
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            used[u] = true;
            int v = favorite[u];
            // 状态转移
            f[v] = Math.max(f[v], f[u] + 1);
            --indeg[v];
            if (indeg[v] == 0) {
                queue.offer(v);
            }
        }
        // ring 表示最大的环的大小
        // total 表示所有环大小为 2 的「基环内向树」上的最长的「双向游走」路径之和
        int ring = 0, total = 0;
        for (int i = 0; i < n; ++i) {
            if (!used[i]) {
                int j = favorite[i];
                // favorite[favorite[i]] = i 说明环的大小为 2
                if (favorite[j] == i) {
                    total += f[i] + f[j];
                    used[i] = used[j] = true;
                }
                // 否则环的大小至少为 3，我们需要找出环
                else {
                    int u = i, cnt = 0;
                    while (true) {
                        ++cnt;
                        u = favorite[u];
                        used[u] = true;
                        if (u == i) {
                            break;
                        }
                    }
                    ring = Math.max(ring, cnt);
                }
            }
        }
        return Math.max(ring, total);
    }
}