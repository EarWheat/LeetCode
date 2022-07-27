package leetcode.Five.fractionAddition;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/27 3:34 PM
 * @Version: 1.initial version; 2022/7/27 3:34 PM
 */
public class Solution {
    public String fractionAddition(String expression) {
        String[] split = expression.split("-");
        StringBuilder stringBuilder = new StringBuilder();
        if (!expression.startsWith("-")) {
            stringBuilder.append(split[0]);
        }
        for (int i = 1; i < split.length; i++) {
            stringBuilder.append("+-").append(split[i]);
        }
        expression = stringBuilder.toString();
        String[] expressions = expression.split("\\+");
        String result = expressions[0];
        for (int i = 1; i < expressions.length; i++) {
            result = cal2(result, expressions[i]);
        }
        return result;
    }

    public String cal2(String num1, String num2) {
        if (num1.equals("")) {
            return num2;
        }
        String[] n1 = num1.split("/");
        String[] n2 = num2.split("/");
        int n1FenZi = Integer.parseInt(n1[0]);
        int n1FenMu = Integer.parseInt(n1[1]);
        int n2FenZi = Integer.parseInt(n2[0]);
        int n2FenMu = Integer.parseInt(n2[1]);
        // 通分
        if (n1FenMu != n2FenMu) {
            n1FenZi *= n2FenMu;
            n2FenZi *= n1FenMu;
            n2FenMu *= n1FenMu;
        }
        int resultFenZi = n1FenZi + n2FenZi;
        // 约分
        return modNum(resultFenZi, n2FenMu);
    }

    public String modNum(int fenZi, int fenMu) {
        if (fenZi == 0) {
            return "0/1";
        }
        if (Math.abs(fenZi) < 2) {
            return fenZi + "/" + fenMu;
        }
        int i = 1;
        while (i < Math.abs(fenZi)) {
            for (i = 2; i <= Math.abs(fenZi); i++) {
                if (fenMu % i == 0 && fenZi % i == 0) {
                    fenMu = fenMu / i;
                    fenZi = fenZi / i;
                    break;
                }
            }
        }
        return fenZi + "/" + fenMu;
    }

    public static void main(String[] args) {
        String s = "1/2+1/2";
        Solution solution = new Solution();
        System.out.println(solution.fractionAddition(s));
    }
}
