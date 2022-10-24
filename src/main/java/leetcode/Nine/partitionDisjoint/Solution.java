package leetcode.Nine.partitionDisjoint;

/**
 * @Desc: 分割数组
 * @Author: 泽露
 * @Date: 2022/10/24 2:17 PM
 * @Version: 1.initial version; 2022/10/24 2:17 PM
 */
public class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int tempMax = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < leftMax) {
                leftMax = tempMax;
                index = i;
            } else {
                tempMax = Math.max(nums[i], tempMax);
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionDisjoint(new int[]{24, 11, 49, 80, 63, 8, 61, 22, 73, 85}));
    }
}
