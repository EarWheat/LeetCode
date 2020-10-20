package leetcode.History.addStrings;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-03 16:36
 * @desc:给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：

num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。


 */
public class addStrings {
//    public String addStrings(String num1, String num2) {
//        int length = Math.max(num1.length(), num2.length());
//        int diff = num1.length() > num2.length() ? num1.length() - num2.length() : num2.length() - num1.length();
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i = 0; i < diff; i++){
//            stringBuilder.append(0);
//        }
//        String str1,str2;
//        if(num1.length() > num2.length()){
//            stringBuilder.append(num2);
//            str1 = num1;
//            str2 = stringBuilder.toString();
//        } else {
//            stringBuilder.append(num1);
//            str1 = num2;
//            str2 = stringBuilder.toString();
//        }
//        StringBuilder result = new StringBuilder();
//        String temp;
//        for(int i = length - 1; i >= 0; i++){
//            result.append(str1.charAt(i) + str2.charAt(i));
//        }
//        return result.toString();
//    }
    public String addStrings(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i>=0) carry += num1.charAt(i--)-'0';
            if(j>=0) carry += num2.charAt(j--)-'0';
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "1";
        String str2 = "2";
        System.out.println((str1.charAt(0) + str2.charAt(0)));
    }
}
