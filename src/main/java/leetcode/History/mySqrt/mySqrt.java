package leetcode.History.mySqrt;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-09 17:46
 * @desc:实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。


 */
public class mySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(2147483647));
//        System.out.println(Math.sqrt(2147483647));
    }

    public static int mySqrt(int x) {
        if (x <= 1){
            return x;
        }
        int left = 0;
        int right = x;
        while (left <= right){
            int middle = (right + left) / 2;
            int temp = x / middle;
            if(temp == middle){
                return middle;
            }
            // 向右查找                               
            if(temp > middle){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }
}
