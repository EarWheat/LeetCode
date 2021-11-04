package leetcode.Three.isPerfectSquare;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/4 7:38 下午
 * @desc ：
 * @prd https://leetcode-cn.com/problems/valid-perfect-square/
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/4      liuzhaolu       firstVersion
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int a = (int) Math.sqrt(num);
        return a * a == num;
    }
}
