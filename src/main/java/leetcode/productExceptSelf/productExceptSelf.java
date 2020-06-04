package leetcode.productExceptSelf;

import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-04 19:04
 * @desc:给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

 

示例:

输入: [1,2,3,4]
输出: [24,12,8,6]
 

提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
* 思路
* 初始化两个空数组 L 和 R。对于给定索引 i，L[i] 代表的是 i 左侧所有数字的乘积，R[i] 代表的是 i 右侧所有数字的乘积。
我们需要用两个循环来填充 L 和 R 数组的值。对于数组 L，L[0] 应该是 1，因为第一个元素的左边没有元素。对于其他元素：L[i] = L[i-1] * nums[i-1]。
同理，对于数组 R，R[length-1] 应为 1。length 指的是输入数组的大小。其他元素：R[i] = R[i+1] * nums[i+1]。
当 R 和 L 数组填充完成，我们只需要在输入数组上迭代，且索引 i 处的值为：L[i] * R[i]。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/product-of-array-except-self/solution/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class productExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] L = new int[nums.length];
        L[0] = nums[0];
        int[] R = new int[nums.length];
        for(int i = 1;i < nums.length; i++){
            L[i] = L[i-1] * nums[i];
//            System.out.print(L[i] + " ");
        }
//        System.out.println();
        R[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length-2; i >= 0; i--){
            R[i] = R[i + 1] * nums[i];
        }
//        for(int i = 0; i < nums.length; i++){
//            System.out.print(R[i] + " ");
//        }
//        System.out.println();
        result[0] = R[1];
        result[nums.length - 1] = L[nums.length -2];
        for(int i = 1; i < nums.length - 1; i++){
            result[i] = L[i - 1] * R[i + 1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
