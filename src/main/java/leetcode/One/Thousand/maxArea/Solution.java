package leetcode.One.Thousand.maxArea;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Desc: 1465. 切割后面积最大的蛋糕
 * @Author: 泽露
 * @Date: 2023/10/27 11:06 AM
 * @Version: 1.initial version; 2023/10/27 11:06 AM
 */
public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H");
        String format = simpleDateFormat.format(time);
        System.out.println(format);
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        return (int) ((long) calMax(horizontalCuts, h) * calMax(verticalCuts, w) % 1000000007);
    }

    public int calMax(int[] arr, int boardr) {
        int res = 0, pre = 0;
        for (int i : arr) {
            res = Math.max(i - pre, res);
            pre = i;
        }
        return Math.max(res, boardr - pre);
    }
}
