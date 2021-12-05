package leetcode.One.Thousand.largestSumAfterKNegations;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/12/3 2:14 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/3 2:14 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] deNums = Arrays.stream(nums).filter(n -> n < 0).toArray();
        int sum = 0;
        if(k <= deNums.length){
            Arrays.sort(nums);
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if(index < k && nums[i] < 0){
                    sum += -nums[i];
                    index++;
                } else {
                    sum += nums[i];
                }
            }
        } else {
            int mod = k - deNums.length;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Math.abs(nums[i]);
            }
            Arrays.sort(nums);
            if(mod % 2 == 0){
                sum = Arrays.stream(nums).sum();
            } else {
                nums[0] = -nums[0];
                sum = Arrays.stream(nums).sum();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.largestSumAfterKNegations(new int[]{3,-1,0,2}, 3));
//        System.out.println(solution.largestSumAfterKNegations(new int[]{4,2,3}, 1));
        System.out.println(solution.largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2));
    }
}
