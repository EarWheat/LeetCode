package leetcode.Seven.MyCalendar;

import java.util.TreeSet;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/5 12:13 PM
 * @Version: 1.initial version; 2022/7/5 12:13 PM
 */
public class Answer {
    TreeSet<int[]> calendars;

    public Answer() {
        calendars = new TreeSet<>((a, b) -> {
            if(a[1] <= b[0])
                return -1;
            else if(a[0] >= b[1])
                return 1;
            else
                return 0;
        });
    }

    public boolean book(int start, int end) {
        int[] e = new int[]{start, end};
        return calendars.add(e);
    }
}
