package leetcode.Six.solveEquation;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/10 11:33 AM
 * @Version: 1.initial version; 2022/8/10 11:33 AM
 */
public class Solution {
    public String solveEquation(String equation) {
        int factor = 0, val = 0;
        int index = 0, n = equation.length(), sign1 = 1; // 等式左边默认系数为正
        while (index < n) {
            if (equation.charAt(index) == '=') {
                sign1 = -1; // 等式右边默认系数为负
                index++;
                continue;
            }

            int sign2 = sign1, number = 0;
            boolean valid = false; // 记录 number 是否有效
            if (equation.charAt(index) == '-' || equation.charAt(index) == '+') { // 去掉前面的符号
                sign2 = (equation.charAt(index) == '-') ? -sign1 : sign1;
                index++;
            }
            while (index < n && Character.isDigit(equation.charAt(index))) {
                number = number * 10 + (equation.charAt(index) - '0');
                index++;
                valid = true;
            }

            if (index < n && equation.charAt(index) == 'x') { // 变量
                factor += valid ? sign2 * number : sign2;
                index++;
            } else { // 数值
                val += sign2 * number;
            }
        }

        if (factor == 0) {
            return val == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (-val / factor);

    }

    private int calculate(String s) {
        StringBuilder temp = new StringBuilder();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                temp.append(s.charAt(i));
            } else if (s.charAt(i) == '+') {
                int t = Integer.parseInt(temp.toString());
                result += t;
                temp.delete(0, temp.length());
            } else if (s.charAt(i) == '-') {
                int t = Integer.parseInt(temp.toString());
                result -= t;
                temp.delete(0, temp.length());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveEquation("-2+x+4-x=-x+x"));
    }
}
