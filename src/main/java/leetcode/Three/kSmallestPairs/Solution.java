package leetcode.Three.kSmallestPairs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ：liuzhaolu
 * @description：373. 查找和最小的 K 对数字
 * @prd :
 * @date ：2022/1/14 2:05 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/14 2:05 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i,0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2};
        int[] nums2 = new int[]{1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.kSmallestPairs(nums1, nums2, 10));
    }
}
