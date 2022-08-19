package leetcode.One.Thousand.busyStudent;

/**
 * @Desc: 1450 在既定时间做作业的学生人数
 * @Author: 泽露
 * @Date: 2022/8/19 11:32 AM
 * @Version: 1.initial version; 2022/8/19 11:32 AM
 */
public class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int[] time = new int[queryTime + 1];
        for (int i = 0; i < startTime.length; i++) {
            int start = startTime[i];
            int end = endTime[i];
            for (int j = start; j <= Math.min(queryTime, end); j++) {
                time[j]++;
            }
        }
        return time[queryTime];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] startTime = new int[]{1, 2, 3};
        int[] endTime = new int[]{3, 2, 7};
        System.out.println(solution.busyStudent(startTime, endTime, 4));
    }
}

