package leetcode.isNumber;

/*
 * @author:liuzhaolu
 * @createTime: 2020-09-02 12:38
 * @desc:
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。

、、
 */
public class isNumber {
    public boolean isNumber(String s) {
        if(s.length() == 0){
            return false;
        }
        if(s.charAt(0) == '.'){
            return false;
        }
        if(s.charAt(s.length()-1) - '0' > 9 || s.charAt(s.length() - 1) - '0' < 0){
            return false;
        }

        int[] fuhao = new int[5];// +, -, e, E, .
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '+'){
                fuhao[0]++;
                continue;
            }
            if(s.charAt(i) == '-'){
                fuhao[1]++;
                continue;
            }
            if(s.charAt(i) == 'e'){
                fuhao[2]++;
                continue;
            }
            if(s.charAt(i) == 'E'){
                fuhao[3]++;
                continue;
            }
            if(s.charAt(i) == '.'){
                fuhao[4]++;
                continue;
            }
            if(s.charAt(i) - '0' > 9 || s.charAt(s.length() - 1) - '0' < 0){
                return false;
            }
        }
        if(fuhao[2] > 1 || fuhao[3] > 1 || fuhao[4] > 1){
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println('9'-'0');
        System.out.println('a'-'0');
    }
}
