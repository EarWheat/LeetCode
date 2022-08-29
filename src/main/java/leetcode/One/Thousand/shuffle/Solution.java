package leetcode.One.Thousand.shuffle;

import java.util.Arrays;

/**
 * @Desc: 1470 重新排列数组
 * @Author: 泽露
 * @Date: 2022/8/29 5:24 PM
 * @Version: 1.initial version; 2022/8/29 5:24 PM
 */
public class Solution {
    /**
     * 输入：nums = [2,5,1,3,4,7], n = 3 输出：[2,3,5,4,1,7] 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
     * 2,3,5,1,4,7
     * 2,3,5,4,1,7
     */
    public int[] shuffle(int[] nums, int n) {
        int index = n;
        int insertIndex = 1;
        for (int i = 0; i < n; i++) {
            insert(insertIndex, index, nums);
            index++;
            insertIndex += 2;
        }
        return nums;
    }

    // 在index的位置插入原位置是originIndex的数
    public void insert(int index, int originIndex, int[] nums) {
        // step1: 取出待移动的数
        int temp = nums[originIndex];
        // step2: 移动留出空位
        for (int i = originIndex; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        // step3: 插入
        nums[index] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }
}
