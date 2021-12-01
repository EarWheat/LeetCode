package leetcode.One.Thousand.maxPower;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/12/1 2:54 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/1 2:54 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int maxPower(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        int max = 0;
        int left = 0;
        int right = 1;
        while (right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                right++;
            } else {
                max = Math.max(max, right - left);
                left = right;
            }
        }
        return max;
    }
}
