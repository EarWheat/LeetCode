package leetcode.addBinary;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-23 10:28
 * @desc:给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

 

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"          1010
输出: "10101"                         1011
                                    10101
 */
public class addBinary {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int temp = 0;  // 进位
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0){
            int m = 0;
            if(i >= 0){
                m = Integer.parseInt(String.valueOf(a.charAt(i)));
            }
            int n = 0;
            if(j >= 0){
                n = Integer.parseInt(String.valueOf(b.charAt(j)));
            }
            int result = m + n + temp;
            if(result >= 2){
                temp = 1;
                result = result % 2;
            } else {
                temp = 0;
            }
            stringBuilder.append(result);
            i--;
            j--;
        }
        if(temp != 0){
            stringBuilder.append(temp);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(addBinary("11","1"));
        System.out.println(addBinary("1010","1011"));
    }
}
