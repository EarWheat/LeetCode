package leetcode.Nine.subarraysWithKDistinct;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/9 上午10:20
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    /**
     * 输入：A = [1,2,1,2,3], K = 2
     * 输出：7
     * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        int result = 0;
        int start = 0;
        while (start < A.length){
            Set<Integer> arrays = new HashSet<>(K);
            int i;
            for (i = start; i < A.length; i++) {
                if(!arrays.contains(A[i])){
                    if(arrays.size() < K){
                        arrays.add(A[i]);
                    } else {
                        result += calcArraysDistinct(Arrays.copyOfRange(A,start,i),K);
                        start = i - (K - 1);
                        break;
                    }
                }
            }
            if(i == A.length){
                if(arrays.size() == K){
                    result += calcArraysDistinct(Arrays.copyOfRange(A,start,i),K);
                    break;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 计算数组A按K分的可能性组合
     * @param A
     * @return
     */
    public int calcArraysDistinct(int[] A, int K){
        if(A.length < K){
            return 0;
        }
        if(A.length == K){
            return 1;
        }
        int result = 0;
        int length = A.length;
        for (int subLength = K; subLength <= length; subLength++) {
            for (int i = 0; i <= length - subLength; i++) {
                if(isContinueArray(Arrays.copyOfRange(A, i, i + subLength), K)){
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 判断是否符合要求的连续子数组
     * @param A
     * @return
     */
    public boolean isContinueArray(int[] A, int K){
        Set<Integer> set = new HashSet<>(A.length);
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        return set.size() == K;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.subarraysWithKDistinct(array,2));
    }
}
