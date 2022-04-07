package leetcode.Seven.rotateString;

/**
 * @author ：liuzhaolu
 * @description：796. 旋转字符串
 * @prd : https://leetcode-cn.com/problems/rotate-string/
 * @date ：2022/4/7 5:25 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/7 5:25 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean rotateString(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == goal.charAt(0)){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(s.substring(i));
                stringBuilder.append(s.substring(0, i));
                if(stringBuilder.toString().equalsIgnoreCase(goal)){
                    return true;
                }
            }
        }
        return false;
    }
}
