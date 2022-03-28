package leetcode.Six.hasAlternatingBits;

/**
 * @author ：liuzhaolu
 * @description：693. 交替位二进制数
 * @prd : https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 * @date ：2022/3/28 2:07 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/28 2:07 下午     liuzhaolu       firstVersion
 */
public class Solution {
    // 1011
    // 0010
    public boolean hasAlternatingBits(int n) {
        int temp = 1;
        int preIndex = n & temp;
        temp = temp << 1;
        int num = 1;
        while (temp < n) {
            int t = (n & temp) >> num;
            if (t != preIndex) {
                preIndex = t;
            } else {
                return false;
            }
            temp = temp << 1;
            num++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(11));
    }
}
