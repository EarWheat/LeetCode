package leetcode.Two.Thousand.countDigits;

/**
 * @Desc: 统计能整除数字的位数
 * @Author: 泽露
 * @Date: 2023/10/26 5:46 PM
 * @Version: 1.initial version; 2023/10/26 5:46 PM
 */
public class Solution {
    public int countDigits(int num) {
        int t = num;
        int res = 0;
        while (t != 0) {
            if (num % (t % 10) == 0) {
                res++;
            }
            t /= 10;
        }
        return res;
    }
}
