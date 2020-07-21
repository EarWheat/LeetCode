package leetcode.twoSum;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-20 17:17
 * @desc:
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
        int[] test = new int[]{2, 7, 11, 15};
        int[] show = twoSumSolution(test,9);
    }
}
