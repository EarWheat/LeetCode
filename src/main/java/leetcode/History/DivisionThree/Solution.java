package leetcode.History.DivisionThree;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-26 11:53
 * @desc:小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。

并且小Q对于能否被3整除这个性质很感兴趣。

小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
* @input
* 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
* @output
* 输出一个整数, 表示区间内能被3整除的数字个数。
* @example
* 2 5
* 3
* 12, 123, 1234, 12345...
其中12, 123, 12345能被3整除。
 */
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int index = l;
        int count = 0;
        while (index <= r){
            if(ListSum(index) % 3 == 0){
                count++;
            }
            index++;
        }
        System.out.println(count);
    }

    private static int ListSum(int length){
        int sum = 0;
        for(int i = 1;i <= length;i++){
            sum += i;
        }
        return sum;
    }
}
