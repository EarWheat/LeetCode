package leetcode.Eight.flipAndInvertImage;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/24 下午2:55
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int lineLength = A[0].length;
        int middle = lineLength / 2;
        for (int i = 0; i < A.length; i++) {
            if(lineLength % 2 != 0){
                A[i][middle] = converse(A[i][middle]);
            }
            int j = 0;
            while (j < middle){
                int temp = A[i][j];
                A[i][j] = converse(A[i][lineLength - 1 - j]);
                A[i][lineLength - 1 - j] = converse(temp);
                j++;
            }
        }
        return A;
    }

    public int converse(int i){
        if(i == 1){
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.flipAndInvertImage(A)));
    }
}
