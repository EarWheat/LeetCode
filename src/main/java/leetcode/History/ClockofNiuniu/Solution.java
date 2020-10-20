package leetcode.History.ClockofNiuniu;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-29 17:07
 * @desc:牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
 * @input:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
 * 接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
 * 接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
 * 接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
 * 数据保证至少有一个闹钟可以让牛牛及时到达教室。
 * @output:
 * 输出两个整数表示牛牛最晚起床时间。
 * @example:
 * 3
 * 5 0
 * 6 0
 * 7 0
 * 59
 * 6 59
 *
 * 6 0
 */
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][2];
        int[] targetTime = new int[2];
        for(int i = 0; i < n; i++){
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
        }
        int needTime = scanner.nextInt();
        targetTime[0] = scanner.nextInt();
        targetTime[1] = scanner.nextInt();
        int targetMin = time2Min(targetTime);
        int lastMin = targetMin - needTime;    //最晚出发时间
        int[] temp = new int[2];
        for(int i = 0; i < n; i++){
            int m = time2Min(array[i]);
            if(lastMin >= m){
                int tempMin = time2Min(temp);
                if(m > tempMin){
                    temp = array[i];
                }
            }
        }
        System.out.println(temp[0]+" "+temp[1]);
    }

    //时间转分钟
    private static int time2Min(int[] array){
        if(array.length == 0){
            return 0;
        }
        return array[0] * 60 + array[1];
    }

    //分钟转时间
    private static int[][] min2Time(int min){
        int[][] costTime = new int[1][1];
        if(min < 60){
            costTime[0][0] = 0;
            costTime[0][1] = min;
        } else {
            costTime[0][0] = min % 60;
            costTime[0][1] = min / 60;
        }
        return costTime;
    }
}
