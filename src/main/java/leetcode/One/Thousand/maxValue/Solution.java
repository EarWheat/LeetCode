package leetcode.One.Thousand.maxValue;
//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
//
//
// nums.length == n
// nums[i] 是 正整数 ，其中 0 <= i < n
// abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
// nums 中所有元素之和不超过 maxSum
// nums[index] 的值被 最大化
//
//
// 返回你所构造的数组中的 nums[index] 。
//
// 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
//
//
//
// 示例 1：
//
// 输入：n = 4, index = 2,  maxSum = 6
//输出：2
//解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
// maxSum = 8
// sub = 4
// index = 2
// result = 3
// 1,2,3,2
//
//
// 示例 2：
//
// 输入：n = 6, index = 1,  maxSum = 10
//输出：3
//
//
//
//
// 提示：
//
//
// 1 <= n <= maxSum <= 10⁹
// 0 <= index < n
//
// Related Topics 贪心 二分查找 👍 116 👎 0

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/1/4 4:21 PM
 * @Version: 1.initial version; 2023/1/4 4:21 PM
 */
public class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (valid(mid, n, index, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean valid(int mid, int n, int index, int maxSum) {
        int left = index;
        int right = n - index - 1;
        return mid + cal(mid, left) + cal(mid, right) <= maxSum;
    }

    public long cal(int big, int length) {
        if (length + 1 < big) {
            int small = big - length;
            return (long) (big - 1 + small) * length / 2;
        } else {
            int ones = length - (big - 1);
            return (long) big * (big - 1) / 2 + ones;
        }
    }
}
