package Interview.findNthDigit;

/**
 * @Desc: https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * @Author: 泽露
 * @Date: 2022/6/15 2:15 PM
 * @Version: 1.initial version; 2022/6/15 2:15 PM
 */
public class Solution {
    public int findNthDigit(int n) {
        int digit = 1;   // n所在数字的位数
        long start = 1;  // 数字范围开始的第一个数
        long count = 9;  // 占多少位
        while(n > count){
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
