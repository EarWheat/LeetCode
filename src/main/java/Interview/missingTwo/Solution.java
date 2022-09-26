package Interview.missingTwo;
//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
//
// 以任意顺序返回这两个数字均可。
//
// 示例 1:
//
// 输入: [1]
//输出: [2,3]
//
// 示例 2:
//
// 输入: [2,3]
//输出: [1,4]
//
// 提示：
//
//
// nums.length <= 30000
//
// Related Topics 位运算 数组 哈希表 👍 163 👎 0

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/9/26 4:27 PM
 * @Version: 1.initial version; 2022/9/26 4:27 PM
 */
public class Solution {
    public int[] missingTwo(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int num = 0;
        int index = 1;
        int i = 0;
        while (i < nums.length){
            if (nums[i] == index) {
                i++;
            } else {
                result[num++] = index;
            }
            index++;
        }
        int left =  2 - num;
        for (i = 0; i < left; i++) {
            result[num++] = index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingTwo(new int[]{2,3}));
    }
}
