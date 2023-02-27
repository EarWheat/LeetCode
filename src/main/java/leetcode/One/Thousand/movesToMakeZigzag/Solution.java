package leetcode.One.Thousand.movesToMakeZigzag;
//给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
//
// 如果符合下列情况之一，则数组 A 就是 锯齿数组：
//
//
// 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
// 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
//
//
// 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
//
//
//
// 示例 1：
//
// 输入：nums = [1,2,3]
//输出：2
//解释：我们可以把 2 递减到 0，或把 3 递减到 1。
//
//
// 示例 2：
//
// 输入：nums = [9,6,1,6,2]
//输出：4
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 1000
//
// Related Topics 贪心 数组 👍 43 👎 0
// action2
/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/10/18 5:23 PM
 * @Version: 1.initial version; 2022/10/18 5:23 PM
 */
public class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int ans1 = 0, ans2 = 0;// 偶大， 奇大
        int[] nums1 = nums.clone();// 奇数用
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {// 偶数位置
                if (i + 1 < nums.length && nums[i] <= nums[i + 1]) {// 后大，偶数大不满足，需要增加ans1
                    ans1 += nums[i + 1] - nums[i] + 1;
                    nums[i + 1] = nums[i] - 1;
                }
                if (i + 1 < nums.length && nums1[i] >= nums1[i + 1]) {// 后大，奇数大不满足，需要增加ans2
                    ans2 += nums1[i] - nums1[i + 1] + 1;
                    nums1[i] = nums1[i + 1] - 1;
                }
            } else {// 奇数位置
                if (i + 1 < nums.length && nums[i] >= nums[i + 1]) {// 后大，偶数大不满足，需要增加ans1
                    ans1 += nums[i] - nums[i + 1] + 1;
                    nums[i] = nums[i + 1] - 1;
                }
                if (i + 1 < nums.length && nums1[i] <= nums1[i + 1]) {// 后大，奇数大不满足，需要增加ans2
                    ans2 += nums1[i + 1] - nums1[i] + 1;
                    nums1[i + 1] = nums1[i] - 1;
                }
            }
        }
        return Math.min(ans1, ans2);
    }
}
