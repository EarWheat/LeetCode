package leetcode.Nine.sortedSquares;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-16 09:52
 * @desc 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class sortedSquares {
    public static int[] sortedSquares(int[] A) {
        // 双指针只需遍历一遍
        int i; // 左指针
        for(i = 0; i < A.length; i++){
            if(A[i] >= 0){
                break;
            }
        }
        int left = i - 1;
        int right = i; // 正数起始index
        int n = 0; // result结果
        int[] result = new int[A.length];
        while (left >= 0 && right < A.length){
            if(Math.abs(A[left]) > A[right]){
                result[n++] = (int) Math.pow(A[right],2);
                right++;
            } else {
                result[n++] = (int) Math.pow(A[left],2);
                left--;
            }
        }
        // 循环结束后剩余左或者右待遍历
        while (left >= 0){
            result[n++] = (int)Math.pow(A[left],2);
            left--;
        }
        while (right < A.length){
            result[n++] = (int) Math.pow(A[right],2);
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-7,-4,-3,-1,0,2,3,10,11,13,20,21,22,23};
        int[] result = sortedSquares(test);
        System.out.println(result.length);
    }
}
