package leetcode.One.Thousand.addNegabinary;
//给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。
//
// 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 +
// (-2)^2 + (-2)^0 = -3。数组形式 中的数字 arr 也同样不含前导零：即 arr == [0] 或 arr[0] == 1。
//
// 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。
//
//
//
// 示例 1：
//
//
//输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
//输出：[1,0,0,0,0]
//解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
//
//
//
//
// 示例 2：
//
//
//输入：arr1 = [0], arr2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：arr1 = [0], arr2 = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
//
// 1 <= arr1.length, arr2.length <= 1000
// arr1[i] 和 arr2[i] 都是 0 或 1
// arr1 和 arr2 都没有前导0
//
// Related Topics 数组 数学 👍 92 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/5/18 2:25 PM
 * @Version: 1.initial version; 2023/5/18 2:25 PM
 */
public class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1;
        int carry = 0;
        List<Integer> ans = new ArrayList<Integer>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = carry;
            if (i >= 0) {
                x += arr1[i];
            }
            if (j >= 0) {
                x += arr2[j];
            }
            if (x >= 2) {
                ans.add(x - 2);
                carry = -1;
            } else if (x >= 0) {
                ans.add(x);
                carry = 0;
            } else {
                ans.add(1);
                carry = 1;
            }
            --i;
            --j;
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        int[] arr = new int[ans.size()];
        for (i = 0, j = ans.size() - 1; j >= 0; i++, j--) {
            arr[i] = ans.get(j);
        }
        return arr;
    }
}