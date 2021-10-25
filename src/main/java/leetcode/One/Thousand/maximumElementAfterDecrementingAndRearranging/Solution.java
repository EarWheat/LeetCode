package leetcode.One.Thousand.maximumElementAfterDecrementingAndRearranging;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/15 下午5:06
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i] - arr[i - 1]) > 1){
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,2,1};
        Solution solution = new Solution();
        System.out.println(solution.maximumElementAfterDecrementingAndRearranging(arr));
    }
}
