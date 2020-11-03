package leetcode.Nine.validMountainArray;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-03 12:03
 * @desc 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 *
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class validMountainArray {
    public static boolean validMountainArray(int[] A) {
        if(A.length < 3){
            return false;
        }
        int max = 0;
        int middle = 0;
        for(middle = 0; middle < A.length - 1; middle++){
            if(A[middle] > A[middle + 1]){
                max = A[middle];
                break;
            }
            if(A[middle] == A[middle + 1]){
                return false;
            }
        }
        if(A[A.length - 1] == max || middle == A.length - 1 || middle == 0){
            return false;
        }
        middle++;
        while (middle < A.length){
            if(A[middle] > max){
                return false;
            }
            if(A[middle] >= A[middle - 1]){
                return false;
            }
            middle++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3}));
    }
}
