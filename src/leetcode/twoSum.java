package leetcode;

/**
 * @author liuzhaolu
 * @version create_time：2018/11/10 类说明:
 */


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */


public class twoSum {

    private static int[] twoSumSolution(int[] nums, int target) {
        int[] result = new int[2];
        int r = 0;
        for(int i = 0 ; i < nums.length; i++){
           int temp = target - nums[i];
           for(int j = i + 1;j < nums.length;j++){
               if(temp == nums[j]){
                   result[r] = i;
                   result[r+1] = j;
                   break;
               }
           }
        }
        return result;
    }

    public static void main(String[] args){
        int[] test = new int[]{3,3};
        int[] show = twoSumSolution(test,6);
    }

}
