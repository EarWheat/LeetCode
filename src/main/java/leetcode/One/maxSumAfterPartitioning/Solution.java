package leetcode.One.maxSumAfterPartitioning;
//给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
//
// 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。
//
//
//
// 示例 1：
//
//
//输入：arr = [1,15,7,9,2,5,10], k = 3
//输出：84
//解释：数组变为 [15,15,15,9,10,10,10]
//
// 示例 2：
//
//
//输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
//输出：83
//
//
// 示例 3：
//
//
//输入：arr = [1], k = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 500
// 0 <= arr[i] <= 10⁹
// 1 <= k <= arr.length
//
// Related Topics 数组 动态规划 👍 217 👎 0
/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/4/19 2:36 PM
 * @Version: 1.initial version; 2023/4/19 2:36 PM
 */
public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxValue = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                d[i] = Math.max(d[i], d[j] + maxValue * (i - j));
                if (j > 0) {
                    maxValue = Math.max(maxValue, arr[j - 1]);
                }
            }
        }
        return d[n];
    }
}
