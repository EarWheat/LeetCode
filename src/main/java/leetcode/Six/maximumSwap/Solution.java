package leetcode.Six.maximumSwap;

//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
//
// 示例 1 :
//
//
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
//
//
// 示例 2 :
//
//
//输入: 9973
//输出: 9973
//解释: 不需要交换。
//
//
// 注意:
//
//
// 给定数字的范围是 [0, 10⁸]
//
// Related Topics 贪心 数学 👍 328 👎 0


import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/9/13 4:30 PM
 * @Version: 1.initial version; 2022/9/13 4:30 PM
 */
public class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        Character[] nums = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i);
        }
        int end = s.length();
        int start = 0;
        while (start < s.length() && nums[start] == '9') {
            start++;
        }
        // 找出最大值index
        int maxIndex = findMax(nums, start, end - 1);
        while (start < maxIndex) {
            if (nums[start] < nums[maxIndex]) {
                swap(nums, start, maxIndex);
                break;
            }
            start++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(nums).forEach(stringBuilder::append);
        return Integer.parseInt(stringBuilder.toString());
    }

    public void swap(Character[] nums, int i, int j) {
        char temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public int findMax(Character[] nums, int start, int end) {
        Character max = nums[end];
        int maxIndex = end;
        for (int i = end - 1; i > start; i--) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumSwap(9));
    }
}
