package leetcode.History.reversePairs;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-24 16:54
 * @desc:在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 输入: [7,5,6,4]
输出: 5
 */
public class reversePairs {
    public static void main(String[] args) {
        int[] test = {7,5,6,4};
        System.out.println(reversePairs(test));
    }

    public static int reversePairs(int[] nums) {
        int result = 0;
        for(int i = 0 ; i < nums.length -1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    result++;
                }
            }
        }
        return result;
    }

}
