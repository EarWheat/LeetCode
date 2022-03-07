package leetcode.Five.convertToBase7;

/**
 * @author ：liuzhaolu
 * @description：504. 七进制数
 * @prd : https://leetcode-cn.com/problems/base-7/
 * @date ：2022/3/7 2:53 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/7 2:53 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public String convertToBase7(int num) {
        boolean flag = false;
        if (num < 0) {
            num = Math.abs(num);
            flag = true;
        }
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.append(num % 7);
            num /= 7;
        }
        if (flag) {
            return "-" + res.toString();
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToBase7(100));
    }
}
