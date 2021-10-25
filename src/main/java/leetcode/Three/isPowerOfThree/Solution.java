package leetcode.Three.isPowerOfThree;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/23 4:53 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1){
            return true;
        }
        if(n % 3 != 0){
            return false;
        }
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(27));
    }
}
