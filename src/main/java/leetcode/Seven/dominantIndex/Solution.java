package leetcode.Seven.dominantIndex;

/**
 * @author ：liuzhaolu
 * @description：747. 至少是其他数字两倍的最大数
 * @prd : https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 * @date ：2022/1/13 4:10 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/13 4:10 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int max = nums[0];
        int secondMax = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max){
                secondMax = max;
                max = nums[i];
                index = i;
            }
            if(nums[i] < max && nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        return max >= secondMax * 2 ? index : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dominantIndex(new int[]{3,6,1,0}));
    }
}
