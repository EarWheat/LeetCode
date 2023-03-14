package leetcode.One.minSubarray;
//给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
//
// 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
//
// 子数组 定义为原数组中连续的一组元素。
//
//
//
// 示例 1：
//
// 输入：nums = [3,1,4,2], p = 6
//输出：1
//解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
//
//
// 示例 2：
//
// 输入：nums = [6,3,5,2], p = 9
//输出：2
//解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
//
//
// 示例 3：
//
// 输入：nums = [1,2,3], p = 3
//输出：0
//解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
//
//
// 示例 4：
//
// 输入：nums = [1,2,3], p = 7
//输出：-1
//解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
//
//
// 示例 5：
//
// 输入：nums = [1000000000,1000000000,1000000000], p = 3
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁹
// 1 <= p <= 10⁹
//
// Related Topics 数组 哈希表 前缀和 👍 120 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/3/10 11:22 AM
 * @Version: 1.initial version; 2023/3/10 11:22 AM
 */
public class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % p == 0) {
            return 0;
        }
        if (nums.length == 1 || sum < p) {
            return -1;
        }
        // 余数
        long last = sum % p;
        int result = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int tempSum = nums[0];
        while (r < nums.length) {
            while (tempSum < last) {
                r++;
                if (r >= nums.length) {
                    break;
                }
                tempSum += nums[r];
            }
            if (last == tempSum) {
                result = Math.min(result, r - l + 1);
                r++;
                if (r >= nums.length) {
                    break;
                }
                tempSum += nums[r];
            } else {
                tempSum -= nums[l];
                l++;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int answer(int[] nums, int p){
        int x = 0;
        for (int num : nums) {
            x = (x + num) % p;
        }
        if (x == 0) {
            return 0;
        }
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        int y = 0, res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            index.put(y, i); // f[i] mod p = y，因此哈希表记录 y 对应的下标为 i
            y = (y + nums[i]) % p;
            if (index.containsKey((y - x + p) % p)) {
                res = Math.min(res, i - index.get((y - x + p) % p) + 1);
            }
        }
        return res == nums.length ? -1 : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubarray(new int[]{1000000000,1000000000,1000000000}, 3));
    }
}
