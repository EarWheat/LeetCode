package leetcode.Nine.addToArrayForm;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/22 下午2:22
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        if(K == 0){
            List<Integer> res = new ArrayList<>();
            Arrays.stream(A).forEach(res::add);
            return res;
        }

        int index = String.valueOf(K).length();
        int[] B = new int[index];
        index--;
        while (K >= 1){
            B[index] = K % 10;
            K = K / 10;
            index--;
        }
        int indexA = A.length - 1;
        int indexB = B.length - 1;
        if(A.length > B.length){
            int temp = 0;
            while (indexB >= 0){
                int t = A[indexA] + B[indexB] + temp;
                if(t >= 10){
                    A[indexA] = t % 10;
                    temp = t / 10;
                } else {
                    A[indexA] = t;
                    temp = 0;
                }
                indexA--;
                indexB--;
            }
            while (indexA >= 0){
                int t = A[indexA] + temp;
                if(t >= 10){
                    A[indexA] = t % 10;
                    temp = t /10;
                } else {
                    A[indexA] = t;
                    temp = 0;
                }
                indexA--;
            }
            List<Integer> res = new ArrayList<>();
            if(temp == 1){
                res.add(1);
            }
            Arrays.stream(A).forEach(res::add);
            return res;
        } else {
            int temp = 0;
            while (indexA >= 0){
                int t = A[indexA] + B[indexB] + temp;
                if(t >= 10){
                    B[indexB] = t % 10;
                    temp = t / 10;
                } else {
                    B[indexB] = t;
                    temp = 0;
                }
                indexA--;
                indexB--;
            }
            while (indexB >= 0){
                int t = B[indexB] + temp;
                if(t >= 10){
                    B[indexB] = t % 10;
                    temp = t /10;
                } else {
                    B[indexB] = t;
                    temp = 0;
                }
                indexB--;
            }
            List<Integer> res = new ArrayList<>();
            if(temp == 1){
                res.add(1);
            }
            Arrays.stream(B).forEach(res::add);
            return res;
        }

    }

    public static void main(String[] args) {
        int[] A = new int[]{2,1,5};
        System.out.println(addToArrayForm(A,806));
    }
}
