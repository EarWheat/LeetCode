package leetcode.Two.Thousand.minNumber;
//给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数
//字的某个数位。
//
//
//
// 示例 1：
//
// 输入：nums1 = [4,1,3], nums2 = [5,7]
//输出：15
//解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
//
//
// 示例 2：
//
// 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
//输出：3
//解释：数字 3 的数位 3 在两个数组中都出现了。
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 9
// 1 <= nums1[i], nums2[i] <= 9
// 每个数组中，元素 互不相同 。
//
//
// Related Topics 数组 哈希表 枚举 👍 58 👎 0


import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.stream;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/9/5 3:03 PM
 * @Version: 1.initial version; 2023/9/5 3:03 PM
 */
public class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int s = same(nums1, nums2);
        if (s != -1) {
            return s;
        }

        int x = stream(nums1).min().getAsInt();
        int y = stream(nums2).min().getAsInt();
        return Math.min(x * 10 + y, y * 10 + x);
    }

    public int same(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<Integer>();
        for (int num : nums1) {
            s.add(num);
        }
        int x = 10;
        for (int num : nums2) {
            if (s.contains(num)) {
                x = Math.min(x, num);
            }
        }
        return x == 10 ? -1 : x;
    }
}
