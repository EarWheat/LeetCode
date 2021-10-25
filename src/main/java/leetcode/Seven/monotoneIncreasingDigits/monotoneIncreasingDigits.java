package leetcode.Seven.monotoneIncreasingDigits;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-15 15:36
 * @desc 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数
 *
 * 35576
 * 35569
 *
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class monotoneIncreasingDigits {
    public static int monotoneIncreasingDigits(int N) {
        if(N < 10){
            return N;
        }
        int preLast = 9; // 初始个位最大值为9
        int index = -1;  // 0是个位，1是十位.....
        int result = 0;
        while (N >= 1){
            index++;
            int last = N % 10;
            if(last <= preLast){
                result += Math.pow(10,index) * last;
                preLast = last;
            } else {
                result = (int) (Math.pow(10,index) * (last - 1) + numOfNine(index));
                preLast = last - 1;
            }
            N = N / 10;
        }
        return result;
    }

    // length个9
    public static int numOfNine(int length){
        int result = 0;
        for(int i = 0;i < length;i++){
            result += Math.pow(10,i) * 9;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(monotoneIncreasingDigits(120));
        System.out.println(monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits(35576));
    }
}
