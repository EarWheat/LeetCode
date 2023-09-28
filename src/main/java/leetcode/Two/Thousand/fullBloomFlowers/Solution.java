package leetcode.Two.Thousand.fullBloomFlowers;
//给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从
//starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
//
// 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
//
//
//
// 示例 1：
//
//
//
//
//输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
//输出：[1,2,2,2]
//解释：上图展示了每朵花的花期时间，和每个人的到达时间。
//对每个人，我们返回他们到达时在花期内花的数目。
//
//
// 示例 2：
//
//
//
//
//输入：flowers = [[1,10],[3,3]], people = [3,3,2]
//输出：[2,2,1]
//解释：上图展示了每朵花的花期时间，和每个人的到达时间。
//对每个人，我们返回他们到达时在花期内花的数目。
//
//
//
//
// 提示：
//
//
// 1 <= flowers.length <= 5 * 10⁴
// flowers[i].length == 2
// 1 <= starti <= endi <= 10⁹
// 1 <= people.length <= 5 * 10⁴
// 1 <= people[i] <= 10⁹
//
//
// Related Topics 数组 哈希表 二分查找 有序集合 前缀和 排序 👍 107 👎 0

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/9/28 2:56 PM
 * @Version: 1.initial version; 2023/9/28 2:56 PM
 */
public class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int[] flower : flowers) {
            cnt.put(flower[0], cnt.getOrDefault(flower[0], 0) + 1);
            cnt.put(flower[1] + 1, cnt.getOrDefault(flower[1] + 1, 0) - 1);
        }
        int m = persons.length;
        Integer[] indices = IntStream.range(0, m).boxed().toArray(Integer[]::new);
        Arrays.sort(indices, (i, j) -> persons[i] - persons[j]);
        int[] ans = new int[m];
        int curr = 0;
        for (int x : indices) {
            while (!cnt.isEmpty() && cnt.firstKey() <= persons[x]) {
                curr += cnt.pollFirstEntry().getValue();
            }
            ans[x] = curr;
        }
        return ans;
    }
}

