package leetcode.One.Thousand.dayOfTheWeek;

/**
 * @author ：liuzhaolu
 * @description：1185. 一周中的第几天
 * @prd : https://leetcode-cn.com/problems/day-of-the-week/
 * @date ：2022/1/3 9:13 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/3 9:13 上午     liuzhaolu       firstVersion
 */
public class Solution {
    int[] monthDay = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    String[] days = new String[]{"Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", };
    // 2022-01-03 - 1971-01-01
    public String dayOfTheWeek(int day, int month, int year) {
        int totalDay = 0;
        for (int i = 1971; i < year; i++) {
            if(runYear(i)){
                totalDay += 366;
            } else {
                totalDay += 365;
            }
        }
        for (int i = 1; i < month; i++) {
            if(i == 2 && runYear(year)){
                totalDay += 29;
            } else {
                totalDay += monthDay[i - 1];
            }
        }
        totalDay += day - 1;
        return days[totalDay % 7];
    }

    public boolean runYear(int year){
        if(year % 100 == 0){
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfTheWeek(2,3,1973));
    }
}
