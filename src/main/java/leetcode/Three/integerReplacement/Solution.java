package leetcode.Three.integerReplacement;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/19 3:57 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/19      liuzhaolu       firstVersion
 */
public class Solution {
    // 6 -> 3 -> 4
    public int integerReplacement(int n) {
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        if(n % 2 == 0){
            return 1 + integerReplacement(n / 2);
        } else {
            return 1 + Math.min(integerReplacement(n - 1), integerReplacement(n + 1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerReplacement(2147483647));
    }
}
