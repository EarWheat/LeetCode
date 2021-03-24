package leetcode.Four.find132pattern;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/24 上午8:11
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public static boolean find132pattern(int[] nums) {
        if(nums.length <= 2){
            return false;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int min = nums[i];
            int max = min;
            int index = i + 1;
            while (index < nums.length){
                if(nums[index] > min && nums[index] < max){
                    return true;
                }
                max = Math.max(max, nums[index]);
                index++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,4,2};
        System.out.println(find132pattern(nums));

    }
}
