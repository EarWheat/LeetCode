package leetcode.multiply;

import java.util.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-13 11:45
 * @desc:
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

 */
public class multiply {
    /**
     *      123
     * x     45
     * --------
     *      615
     *     492
     * --------
     *     5535
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        LinkedList<Integer> sum = new LinkedList<>();
        LinkedList<Integer> resultList = new LinkedList<>();
        // num2 * num1
        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                sum.add((num2.charAt(j) - '0') * (num1.charAt(i) - '0'));          // 15, 10, 5
            }
            resultList.add(getSum(sum));
            sum.clear();
        }
        return getResult(resultList);
    }

    private static int getSum(LinkedList<Integer> sum){
        int result = 0;
        int temp = 0;
        int index = 1;
        for(Integer i : sum){
            i = i + temp;
            if(i >= 10){
                result += ((i % 10) * index);
                temp = i / 10;
            } else {
                result += (i * index);
                temp = 0;
            }
            index = index * 10;
        }
        return result + (temp * index);
    }

    // 大整数求和

    /**
     * --------                              738
     *      615                             615
     *     492                             492
     * --------
     *     5535
     * @param sum
     * @return
     */
    private static String getResult(LinkedList<Integer> sum){
        StringBuffer result = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        stack.push(sum.getFirst());
        int i = 1;
        while (stack.size() > 0){
            LinkedList<Integer> temp = new LinkedList<>();
            // pop出所有值
            while (stack.size() > 0){
                temp.add(stack.pop());
            }
            int last = 0;
            for(Integer t : temp){
                // 所有数个位相加
                last += t % 10;
                // 从新入栈
                if(t / 10 >= 1){
                    stack.push(t / 10);
                }
            }
            if(last >= 10){
                stack.push(last / 10);
                last = last % 10;
            }
            result.append(last);
            if(i < sum.size()){
                stack.push(sum.get(i));
                i++;
            }
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("45","0"));
        System.out.println(multiply("123","456"));
        System.out.println(multiply("456","123"));
        System.out.println(multiply("123","1"));
        System.out.println(multiply("123456789","987654321"));
    }
}
