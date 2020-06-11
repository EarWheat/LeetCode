package leetcode.dailyTemperatures;

import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-11 15:39
 * @desc:
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
                                69, 71, 72, 73, 73, 74, 75, 76
 */
public class dailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for(int i = 0;i < T.length; i++){
            for(int j = i+1; j < T.length; j++){
                if(T[j] > T[i]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] myAnswer(int[] T){
        int[] result = new int[T.length];
        result[T.length - 1] = 0;
        for(int i = T.length - 2; i >= 0; i--){
            if(T[i] >= T[i+1]){
                int temp = i + 1;
                while (temp < T.length){
                    if(T[i] < T[temp]){
                        result[i] = temp - i;
                        break;
                    }
                    temp++;
                }
            } else {
                result[i] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] T1= new int[]{89,62,70,58,47,47,46,76,100,70};
        System.out.println(Arrays.toString(dailyTemperatures(T1)));
        System.out.println(Arrays.toString(myAnswer(T1)));
    }
}
