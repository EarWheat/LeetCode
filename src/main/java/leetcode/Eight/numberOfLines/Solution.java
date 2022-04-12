package leetcode.Eight.numberOfLines;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：806. 写字符串需要的行数
 * @prd : https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 * @date ：2022/4/12 3:52 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/12 3:52 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] ans = new int[2];
        ans[0] = 1;
        for (char arr : s.toCharArray()) {
            ans[1] += widths[arr - 'a'];
            if (ans[1] > 100) {
                ans[1] = widths[arr - 'a'];
                ans[0]++;
            }
        }
        return ans;
    }
}
