package leetcode.One.maxDepth;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ：liuzhaolu
 * @description：1614. 括号的最大嵌套深度
 * @prd : https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 * @date ：2022/1/7 2:19 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/7 2:19 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int maxDepth(String s) {
        int result = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                temp++;
            }
            if(s.charAt(i) == ')'){
                result = Math.max(result, temp);
                temp--;
            }
        }
        return result;
    }
}
