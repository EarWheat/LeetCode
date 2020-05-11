package main.java.leetcode.myPow;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-11 18:24
 * @desc:实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25

* 思路：pow(2,10) = pow(2,5) * pow(2,5);
* 折半乘法
* pow(2,5) = pow(2,2) * pow(2,3)
 */
public class myPow {

    public static void main(String[] args) {
        System.out.println(myPow(2,10));
        System.out.println(Math.pow(2,10));
        System.out.println("===========");
        System.out.println(myPow(2.1,3));
        System.out.println(Math.pow(2.1,3));
        System.out.println("===========");
        System.out.println(myPow(2,-2));
        System.out.println(Math.pow(2,-2));
        System.out.println("===========");
//        System.out.println(myPow(0.00001,2147483647));
        System.out.println(Math.pow(2,2147483647));
    }

    public static double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        if(n > 0){
            int middle = n / 2;
            if(n % 2 == 0){ // 整除2
                return myPow(x,middle) * myPow(x,middle);
            } else {
                return myPow(x,middle) * myPow(x, middle + 1);
            }
        } else {
            n = -1 * n;  // 转正
            int middle = n / 2;
            if(n % 2 == 0){ // 整除2
                return 1 / (myPow(x, middle) * myPow(x,middle));
            } else {
                return 1 / (myPow(x,middle) * myPow(x,middle+1));
            }
        }
    }

}
