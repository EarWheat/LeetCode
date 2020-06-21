package leetcode.xorOperation;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-21 11:08
 * @desc:
 * 给你两个整数，n 和 start 。

数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。

请返回 nums 中所有元素按位异或（XOR）后得到的结果。



示例 1：

输入：n = 5, start = 0
输出：8
解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
     "^" 为按位异或 XOR 运算符。
示例 2：

输入：n = 4, start = 3
输出：8
解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
示例 3：

输入：n = 1, start = 7
输出：7
示例 4：

输入：n = 10, start = 5
输出：2
 *
 */
public class xorOperation {
    public static int xorOperation(int n, int start) {
        if(n == 1){
            return start;
        }
        if(n % 4 == 0){
            int last = start + 2 * (n - 1);
            return last & (int)Math.pow(2,n-1);
        }
        int p = n % 4;
        int q = n / 4;
        int result = start + 2 * (n * q - 1);
        for(int i = 1; i < p; i++){
            int temp = start + 2 * (n * q - 1 + i);
            result = result ^ temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(5,0));
        System.out.println(xorOperation(4,3));
        System.out.println(xorOperation(1,7));
        System.out.println(xorOperation(10,5));
    }
}
