package leetcode.Fibonacci;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-23 19:31
 * @desc:
 */
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n <= 0){
            System.out.println(0);
            return;
        }
        System.out.println(Fibonacci(n));
    }

    private static int Fibonacci(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
