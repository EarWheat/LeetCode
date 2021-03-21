package leetcode.One.hammingWeight;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/22 上午7:29
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        while (n > 0){
            if(n % 10 == 1){
                result++;
            }
            n = n / 10;
        }
        return result;
    }

    public int hammingWeightV2(int n) {
        int count = 0;
        int i = 0;
        while(i < 32) {   //循环32次
            if((n & 1) == 0)  //统计0的个数
                count++;
            n = n >> 1;   //右移
            i++;
        }

        return 32 - count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(1011));
    }
}
