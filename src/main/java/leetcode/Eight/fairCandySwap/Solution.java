package leetcode.Eight.fairCandySwap;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/1 下午3:27
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public static int[] fairCandySwap(int[] A, int[] B) {
        int totalA = Arrays.stream(A).sum();
        int totalB = Arrays.stream(B).sum();
        if(totalA == totalB){
            return new int[]{0,0};
        }
        int[] result = new int[2];
        if(A.length == 0){
            result[1] = totalB / 2; // 因为答案总存在，不考虑除不尽的情况
            return result;
        }
        if(B.length == 0){
            result[0] = totalA / 2;
            return result;
        }
        if(totalA > totalB){
            int diff = (totalA - totalB) / 2; // 非偶数分不公平
            result = getAndPut(A,B,diff);
        } else {
            int diff = (totalB - totalA) / 2; // 非偶数分不公平
            int[] temp = getAndPut(B,A,diff);
            result[0] = temp[1];
            result[1] = temp[0];
        }
        return result;
    }

    public static int[] getAndPut(int[] A, int[] B, int diff){
        int[] result = new int[2];
        Arrays.sort(A);
        Arrays.sort(B);
        int length = Math.max(A.length, B.length);
        int i = 0;int j = 0;
        while (i < length && j < length){
            if(A[i] > B[j]){
                if(A[i] - B[j] == diff){
                    result[0] = A[i];
                    result[1] = B[j];
                    return result;
                } else {
                    if(A[i] - B[j] < diff){
                        i++;
                    } else {
                        j++;
                    }
                }
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,17,14,1,16};
        int[] B = new int[]{26,11};
        System.out.println(JSONObject.toJSONString(fairCandySwap(A,B)));
        int[] A1 = new int[]{2};
        int[] B1 = new int[]{1,3};
        System.out.println(JSONObject.toJSONString(fairCandySwap(A1,B1)));
        int[] A2 = new int[]{1,2,5};
        int[] B2 = new int[]{2,4};
        System.out.println(JSONObject.toJSONString(fairCandySwap(A2,B2)));
    }
}
