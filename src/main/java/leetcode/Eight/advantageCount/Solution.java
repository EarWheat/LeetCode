package leetcode.Eight.advantageCount;
//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
//数目来描述。
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
//
//
// 示例 2：
//
//
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length <= 10⁵
// nums2.length == nums1.length
// 0 <= nums1[i], nums2[i] <= 10⁹
//
// Related Topics 贪心 数组 双指针 排序 👍 294 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/10/8 5:28 PM
 * @Version: 1.initial version; 2022/10/8 5:28 PM
 */
public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // [2,7,11,15]
        // [1,10,4,11]
        int n = nums1.length;
        int[][] index = new int[n][2];
        for(int i = 0; i < n; i++) {
            index[i][0] = nums2[i]; // 值
            index[i][1] = i;    // 下标
        }
        Arrays.sort(nums1);
        Arrays.sort(index, (a, b) -> b[0] - a[0]);
        int left = 0, right = n - 1;
        for(int i = 0; i < n; i++) {
            if(nums1[right] > index[i][0]) {
                nums2[index[i][1]] = nums1[right];
                right--;
            } else {
                nums2[index[i][1]] = nums1[left];
                left++;
            }
        }
        return nums2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
    }
}
