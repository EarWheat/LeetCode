package leetcode.Two.isPowerOfTwo;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/30 上午9:31
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }
        int count = 0 ;
        while (n > 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(16));
    }
}
