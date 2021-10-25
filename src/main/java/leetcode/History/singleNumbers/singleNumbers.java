package leetcode.History.singleNumbers;

import java.util.HashSet;
import java.util.Set;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-28 11:11
 * @desc:一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

 

示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]

 */
public class singleNumbers extends UtilClass.ShowArray {
    public static void main(String[] args) {
        int[] test = {4,1,4,6};
        int[] test2 = {1,2,10,4,1,4,3,3};
        int[] result = singleNumbers(test);
        int[] result2 = singleNumbers(test2);
        for(int i = 0;i < result.length; i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
        for(int i = 0;i < result2.length; i++){
            System.out.print(result2[i]+" ");
        }
    }

    public static int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int[] result = new int[2];
        int j = 0;
        for(int i : set){
            result[j++] = i;
        }

        return result;
    }
}
