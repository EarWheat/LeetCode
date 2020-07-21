package leetcode.maxCoins;

import java.util.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-19 10:19
 * @desc:
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
示例:

输入: [3,1,5,8]
输出: 167
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*
* 思路：
* 1、找到排除最左和最右的最小值
 */
public class maxCoins {
    public static int maxCoins(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            if(nums[0] > nums[1]){
                return nums[0] * nums[1] + nums[0];
            } else {
                return nums[0] * nums[1] + nums[1];
            }
        }
        // 排除最左和最右
        // 找最小值的index
        int index = 1;
        if(nums[1] <= 1){
            return nums[0] * nums[index + 1] + maxCoins(removeNums(nums,index));
        }
        int max = nums[1];
        for(int i = 2; i < nums.length - 1;i++){
            int temp = nums[i] * nums[i -1] * nums[i + 1];
            if(temp > max){
                index = i;
                max = temp;
            }
        }
        // 戳破i
        int coins = 0;
        coins = nums[index - 1] * nums[index] * nums[index + 1] + maxCoins(removeNums(nums,index));
        return coins;
    }

    // 删除某个元素
    private static int[] removeNums(int[] nums, int index){
        for(int i = index; i < nums.length - 1; i++){
            nums[i] = nums[i + 1];
        }
        return Arrays.copyOfRange(nums,0,nums.length -1 );
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3,1,5,8}));
        System.out.println(maxCoins(new int[]{3,1,5})); // 15 + 15 + 5
        System.out.println(maxCoins(new int[]{9,97,60}));// 97 * 9 * 60 + 9 * 60 + 60     60 * (9 * 97 + 9 + 1)
        //                                               // 97 * 9 + 97 * 60 + 97         97 * (9 * 60 + 9 + 1)
        System.out.println(maxCoins(new int[]{9,76,64,21,97,60}));
        // 21 * 64 * 97 = 130368
        // 64 * 76 * 97 = 471808
        // 9, 76, 97, 60
        // 76 * 97 * 60 = 442320
        // 9, 76, 60 =
    }

    public static Long computeSumWithNull(Long num1, Long num2){
        if(num1 == null && num2 == null){
            return 0L;
        }
        if(num1 == null || num1 == 0){
            return num2;
        }
        if(num2 == null || num2 == 0){
            return num1;
        }
        return num1 + num2;
    }
}
