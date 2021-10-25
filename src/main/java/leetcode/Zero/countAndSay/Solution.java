package leetcode.Zero.countAndSay;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/15 11:29 上午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String pre = countAndSay(n - 1);
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < pre.length()){
            char temp = pre.charAt(i);
            int numOfTemp = 0;
            while (i < pre.length()){
                if(pre.charAt(i) == temp){
                    numOfTemp++;
                    i++;
                } else {
                    break;
                }
            }
            stringBuilder.append(numOfTemp).append(temp);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
        System.out.println(solution.countAndSay(6));
    }
}
