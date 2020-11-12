package leetcode.Nine.sortArrayByParityII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-12 14:09
 * @desc 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class sortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        for(int i = 0; i < A.length; i++){
            if(i % 2 == 0){ // 偶数位置
                if(A[i] % 2 != 0){  // 偶数位置为奇数
                    switchLocation(A,i,1);
                }
            } else {    // 奇数位置
                if(A[i] % 2 == 0){  // 奇数位置为偶数
                    switchLocation(A,i,0);
                }
            }
        }
        return A;
    }

    // 从A[index]向后找一个奇数／偶数交换,isTwo = 0找奇数交换，isTwo = 1找偶数交换
    private void switchLocation(int[] A, int index, int isTwo){
        for(int i = index; i < A.length; i++){
            // 找奇数交换
            if(isTwo == 0 && A[i] % 2 != 0){
                int temp = A[index];
                A[index] = A[i];
                A[i] = temp;
                return;
            }
            // 找偶数交换
            if(isTwo == 1 && A[i] % 2 == 0){
                int temp = A[index];
                A[index] = A[i];
                A[i] = temp;
                return;
            }
        }
    }
}
