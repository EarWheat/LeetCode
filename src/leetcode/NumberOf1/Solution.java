package leetcode.NumberOf1;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2019-10-15 19:32
 * @desc:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {
    private int NumberOf1(int n){
        if(n > 128 || n < -127){
            return -1;
        }
        if(n == 0){
            return 0;
        }
        int temp = n;
        int[] array = new int[8];
        // 负数
        if(n < 0){
            temp = -1 * n;  // 转为正数
        }
        if(temp % 2 == 1){   // 奇数末尾为1
            array[0] = 1;
            temp = temp - 1;  // 转换为偶数
        } else {    // 偶数末尾为0
            array[0] = 0;
        }
        // array写0
        while (temp > 0){
            for(int i = 0 ; i < 8; i++){
                if(Math.pow(2,i) > temp){
                    array[i - 1] = 1;
                    temp = (int) (temp - Math.pow(2,i - 1));
                    break;
                }
            }
        }

        if(n > 0){
            // 统计1
            int count = 0;
            for(int i = 0; i < array.length; i++){
                if(array[i] == 1){
                    count++;
                }
            }
            return count;
        }
        // 负数求补码
        if(n < 0){
            // 最后一位为0，补码后为1，加1后向前进位
            if(n % 2 == 0){
                // 求补码
                for(int i = 0 ; i < array.length; i++){
                    if(array[i] == 0){
                        array[i] = 1;
                    } else if(array[i] == 1){
                        array[i] = 0;
                    }
                }
                // 进位
                int m = 1;
                array[0] = 0;
                for(int i = 1; i < array.length; i++){
                    if(array[i] + m > 1){
                        array[i] = 0;
                        m = 1;
                    } else {
                        array[i] = array[i] + m;
                        m = 0;
                    }
                }
                //
                int count = 0;
                for(int i = 0; i < array.length; i++){
                    if(array[i] == 1){
                        count++;
                    }
                }
                return count + 1;
            } else {    // 最后一位为1，补码后为0，加1不进位
                int count = 0;
                for(int i = 0; i < array.length; i++){
                    if(array[i] == 1){
                        count++;
                    }
                }
                return count + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.NumberOf1(n));
    }
}
