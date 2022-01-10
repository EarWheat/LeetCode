package leetcode.Three.isAdditiveNumber;

/**
 * @author ：liuzhaolu
 * @description：306. 累加数
 * @prd : https://leetcode-cn.com/problems/additive-number/
 * @date ：2022/1/10 3:17 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/10 3:17 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {
        int start = 0;
        int first = 1;
        int second = 2;
        while (first <= num.length() / 2){
            while (second < num.length()){
                int num1 = Integer.parseInt(num.substring(start,first));
                int num2 = Integer.parseInt(num.substring(first, second));
                String sum = String.valueOf(num1 + num2);
                if(sum.equals(num.substring(second, second + sum.length()))){
                    start = first;
                    first = second;
                    if(second + sum.length() == num.length()){
                        return true;
                    }
                }
                second++;
            }
            first++;
            second = first + 1;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAdditiveNumber("1023"));
    }

    class answer {
        public boolean isAdditiveNumber(String num) {
            int n = num.length();
            for (int secondStart = 1; secondStart < n - 1; ++secondStart) {
                if (num.charAt(0) == '0' && secondStart != 1) {
                    break;
                }
                for (int secondEnd = secondStart; secondEnd < n - 1; ++secondEnd) {
                    if (num.charAt(secondStart) == '0' && secondStart != secondEnd) {
                        break;
                    }
                    if (valid(secondStart, secondEnd, num)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean valid(int secondStart, int secondEnd, String num) {
            int n = num.length();
            int firstStart = 0, firstEnd = secondStart - 1;
            while (secondEnd <= n - 1) {
                String third = stringAdd(num, firstStart, firstEnd, secondStart, secondEnd);
                int thirdStart = secondEnd + 1;
                int thirdEnd = secondEnd + third.length();
                if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {
                    break;
                }
                if (thirdEnd == n - 1) {
                    return true;
                }
                firstStart = secondStart;
                firstEnd = secondEnd;
                secondStart = thirdStart;
                secondEnd = thirdEnd;
            }
            return false;
        }

        public String stringAdd(String s, int firstStart, int firstEnd, int secondStart, int secondEnd) {
            StringBuffer third = new StringBuffer();
            int carry = 0, cur = 0;
            while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
                cur = carry;
                if (firstEnd >= firstStart) {
                    cur += s.charAt(firstEnd) - '0';
                    --firstEnd;
                }
                if (secondEnd >= secondStart) {
                    cur += s.charAt(secondEnd) - '0';
                    --secondEnd;
                }
                carry = cur / 10;
                cur %= 10;
                third.append((char) (cur + '0'));
            }
            third.reverse();
            return third.toString();
        }
    }
}
