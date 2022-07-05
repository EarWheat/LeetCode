package leetcode.Seven.MyCalendar;

import java.util.LinkedList;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/5 11:08 AM
 * @Version: 1.initial version; 2022/7/5 11:08 AM
 */
public class MyCalendar {

    private LinkedList<Integer[]> books;

    public MyCalendar() {
        books = new LinkedList<>();
    }

    public boolean book(int start, int end) {
        if (books.size() == 0) {
            Integer[] b = new Integer[]{start, end};
            books.add(b);
            return true;
        } else {
            int index = getIndex(start, end, 0, books.size() - 1);
            Integer[] target = books.get(index);
            if (index == books.size() - 1) {
                if(start >= target[1]){
                    Integer[] b = new Integer[]{start, end};
                    books.add(b);
                    return true;
                } else if(index >= 1){
                    Integer[] pre = books.get(index - 1);
                    if(start >= pre[1] && end <= target[0]){
                        Integer[] b = new Integer[]{start, end};
                        books.add(index, b);
                        return true;
                    }
                }
                return false;
            } else if (index == 0 && end < target[0]) {
                Integer[] b = new Integer[]{start, end};
                books.add(0, b);
                return true;
            } else {
                Integer[] next = books.get(index + 1);
                if (start >= target[1] && end <= next[0]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public int getIndex(int start, int end, int left, int right) {
        if (left == right) {
            return left;
        }
        int middle = (left + right) / 2;
        Integer[] target = books.get(middle);
        if (start == target[0]) {
            return -1;
        }
        if (start > target[0]) {
            return getIndex(start, end, middle + 1, right);
        } else {
            return getIndex(start, end, 0, middle);
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(10, 20); // return True
//        myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
        myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
        myCalendar.book(5, 10);
        myCalendar.book(50, 60);
        myCalendar.book(40, 49);

    }
}
