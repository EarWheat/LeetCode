package leetcode.Two.diffWaysToCompute;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/1 12:12 PM
 * @Version: 1.initial version; 2022/7/1 12:12 PM
 */
public class Solution {
    /**
     * 输入：expression = "2*3-4*5" 输出：[-34,-14,-10,-10,10] 解释： (2*(3-(4*5))) = -34 ((2*3)-(4*5)) = -14 ((2*(3-4))*5) = -10 (2*((3-4)*5)) = -10 (((2*3)-4)*5) = 10
     * @param expression
     * @return
     */
//    public List<Integer> diffWaysToCompute(String expression) {
//        List<Integer> nums = new ArrayList<>();
//        List<Character> chars = new ArrayList<>();
//        int i = 0;
//        while (i < expression.length()) {
//            StringBuilder stringBuilder = new StringBuilder();
//            while (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
//                stringBuilder.append(expression.charAt(i));
//                i++;
//            }
//            nums.add(Integer.parseInt(stringBuilder.toString()));
//            stringBuilder.delete(0, stringBuilder.length());
//            chars.add(expression.charAt(i));
//            i++;
//        }
//    }

    public Integer getValue(String s){
        int right = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                left = i;
            }else if(s.charAt(i) == ')'){
                right = i;
                break;
            }
        }
        if(left == 0 && right == s.length() - 1){
            return getValueWithOut(s.substring(1, s.length() - 1));
        }
        String subString = s.substring(left + 1, right);
        String stringBuilder = s.substring(0, left) +
                getValueWithOut(subString) +
                s.substring(right + 1);
        return getValue(stringBuilder);
    }

    public Integer getValueWithOut(String s){
        if(s.contains("*")){
            String[] nums = s.split("\\*");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            return a * b;
        } else if(s.contains("+")){
            String[] nums = s.split("\\+");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            return a + b;
        } else if(s.contains("-")){
            String[] nums = s.split("-");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            return a - b;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getValue("(2*(3-(4*5)))"));
    }
}
