package leetcode.Two.addDigits;

/**
 * @author ：liuzhaolu
 * @description：258. 各位相加
 * @prd : https://leetcode-cn.com/problems/add-digits/
 * @date ：2022/3/3 10:08 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/3 10:08 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public int addDigits(int num) {
        while (num >= 10){
            int result = 0;
            int temp = num;
            while (temp >= 10){
                result += temp % 10;
                temp = temp / 10;
            }
            result += temp;
            num = result;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addDigits(38));
    }
}
