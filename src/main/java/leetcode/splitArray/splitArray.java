package leetcode.splitArray;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 10:06
 * @desc:
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。

注意:
数组长度 n 满足以下条件:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
示例:

输入:
nums = [7,2,5,10,8]
m = 2

输出:
18

解释:
一共有四种方法将nums分割为2个子数组。
其中最好的方式是将其分为[7,2,5] 和 [10,8]，
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。


 */
public class splitArray {
    public static int splitArray(int[] nums, int m) {
        long sum = 0;
        long max = nums[0];
        for(int i = 0; i < nums.length;i++){
            sum += nums[i];
            max = Math.max(max,nums[i]);
        }
        long left = max;
        long right = sum;
        while (left < right){
            long maxMinSum = (right + left) / 2;
            long tempSum = 0;
            int cnt = 0;
            for(int i = 0; i < nums.length; i++){
                if(tempSum + nums[i] > maxMinSum){
                    cnt++;
                    tempSum = 0;
                }
                tempSum += nums[i];
            }
            cnt++;
            if(cnt > m){
                left = maxMinSum + 1;
            } else {
                right = maxMinSum;
            }
        }
        return (int)left;
    }
}
