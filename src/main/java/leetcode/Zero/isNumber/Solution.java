package leetcode.Zero.isNumber;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/17 下午4:25
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean isNumber(String s) {
        if(s.split("e").length > 2){
            return false;
        }
        if(s.split("E").length > 2){
            return false;
        }
        if(s.contains("e") && s.contains("E")){
            return false;
        }
        if(s.contains("e")){
            if(s.startsWith("e") || s.endsWith("e")){
                return false;
            }
            String left = s.split("e")[0];
            String right = s.split("e")[1];
            return isRightNumber(left) && isRightNumber(right);
        }
        if(s.contains("E")){
            if(s.startsWith("E") || s.endsWith("E")){
                return false;
            }
            String left = s.split("e")[0];
            String right = s.split("e")[1];
            return isRightNumber(left) && isRightNumber(right);
        }
        return isRightNumber(s);
    }

    public boolean isRightNumber(String s){
        if(s.length() == 0){
            return false;
        }
        if(s.length() == 1){
            return !s.equals(".");
        }
        if(s.endsWith("+") || s.endsWith("-")){
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumber("0e"));
    }
}
