package leetcode.Two.missingNumber;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/6 4:37 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/6      liuzhaolu       firstVersion
 */
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.drawTriangle(5);
    }

    public void drawTriangle(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
                // printf(" ");      C语言用这个
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
                // printf("%d", j);;      C语言用这个
            }
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
                // printf(" ");      C语言用这个
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
                // printf(" ");      C语言用这个
            }
            System.out.println();
        }
    }
}
