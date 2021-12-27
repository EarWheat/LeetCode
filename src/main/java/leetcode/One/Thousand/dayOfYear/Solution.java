package leetcode.One.Thousand.dayOfYear;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/12/21 2:04 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/21 2:04 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            ++amount[1];
        }

        int ans = 0;
        for (int i = 0; i < month - 1; ++i) {
            ans += amount[i];
        }
        return ans + day;
    }
}