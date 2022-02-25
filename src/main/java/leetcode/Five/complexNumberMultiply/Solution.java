package leetcode.Five.complexNumberMultiply;

/**
 * @author ：liuzhaolu
 * @description：537. 复数乘法
 * @prd : https://leetcode-cn.com/problems/complex-number-multiplication/
 * @date ：2022/2/25 3:09 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/25 3:09 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int a1 = Integer.parseInt(num1.substring(0,num1.indexOf('+')));
        int a2 = Integer.parseInt(num1.substring(num1.indexOf('+')+1,num1.length()-1));
        int b1 = Integer.parseInt(num2.substring(0,num2.indexOf('+')));
        int b2 = Integer.parseInt(num2.substring(num2.indexOf('+')+1,num2.length()-1));

        int aa = a1 * b1 - a2 * b2;
        int bb = a2 * b1 + a1 * b2;

        return aa +"+"+bb+"i";
    }
}
