package leetcode.Four.fourSumCount;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-27 18:40
 * @desc 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class fourSumCount {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//        int result = 0;
//        for(int i = 0; i < A.length; i++){
//            int tempI = 0 - A[i];
//            for(int j = 0; j < B.length; j++){
//                int tempJ = tempI - B[j];
//                for(int m = 0; m < C.length; m++){
//                    int tempM = tempJ - C[m];
//                    for(int n = 0; n < D.length;n++){
//                        if(tempM == D[n]){
////                            System.out.println(" 0 = " + A[i] + " + " + B[j] + " + " + C[m] + " + " + D[n]);
//                            result++;
//                        }
//                    }
//                }
//            }
//        }
//        return result;
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};
        System.out.println(fourSumCount(A,B,C,D));
    }


    public static Set<Integer> twoSumCount(int[] A, int[] B){
        Set<Integer> result = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int temp = A[i] + B[j];
                if(!result.contains(temp)){
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
