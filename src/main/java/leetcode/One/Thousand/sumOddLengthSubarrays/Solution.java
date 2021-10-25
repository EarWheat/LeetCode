package leetcode.One.Thousand.sumOddLengthSubarrays;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/29 9:02 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int gap = 0; gap * 2 + 1 <= arr.length ; gap++) {
            sum += subArraysSum(arr,gap * 2 + 1);
        }
        return sum;
    }

    public int subArraysSum(int[] arr, int gap){
        int[] result = new int[arr.length - gap + 1];
        int temp = 0;
        for (int i = 0; i < gap; i++) {
            temp += arr[i];
        }
        result[0] = temp;
        for (int i = 1; i < arr.length - gap + 1; i++) {
            result[i] = result[i - 1] - arr[i - 1] + arr[i - 1 + gap];
        }
        return Arrays.stream(result).sum();
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,5,3};
        Solution solution = new Solution();
        System.out.println(solution.sumOddLengthSubarrays(arr));
        System.out.println(solution.sumOddLengthSubarrays(new int[]{1,2}));
        System.out.println(solution.sumOddLengthSubarrays(new int[]{10,11,12}));
    }
}
