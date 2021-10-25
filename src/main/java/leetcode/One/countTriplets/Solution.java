package leetcode.One.countTriplets;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/18 上午10:51
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int countTriplets(int[] arr) {
        if(arr.length <= 3){
            return 0;
        }
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int a = arr[i] ^ arr[j] ^ arr[k];
                    for (int l = k + 1; l < arr.length; l++) {
                        int b = arr[i] ^ arr[j] ^ arr[l];
                        if(a == b){
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    // 标准答案
    public int countTripletsV2(int[] arr) {
        int len = arr.length;
        int ans = 0;

        for(int i = 0; i < len - 1; i ++){
            int sum = 0;
            for(int k = i; k < len ; k ++){
                sum ^= arr[k];
                if (sum == 0 && k > i) {
                    ans += (k - i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,6,7};
        Solution solution = new Solution();
        System.out.println(solution.countTriplets(arr));
    }
}
