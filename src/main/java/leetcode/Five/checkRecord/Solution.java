package leetcode.Five.checkRecord;

import java.util.stream.Stream;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/17 3:22 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean checkRecord(String s) {
        // 缺勤数
        int numA = 0;
        // 连续迟到数
        int continueL = 0;
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if(t == 'A'){
                numA++;
                if(numA >= 2){
                    return false;
                }
                continueL = 0;
            }
            if(t == 'L'){
                continueL++;
                if(continueL >= 3){
                    return false;
                }
            }
            if(t == 'P'){
                continueL = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkRecord("AA"));
    }
}
