package leetcode.threeSum;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-12 14:52
 * @desc:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;
        Arrays.sort(nums);
        // [-4,-1,-1,0,1,2]
        for(int i = 0; i < nums.length; i++){
           if((i > 0 && nums[i] != nums[i - 1]) || i == 0){
               for(int j = i + 1; j < nums.length; j++){
                   if(j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])){
                       for(int k = j + 1; k < nums.length;k++){
                           if((k == j + 1 ) || (k > j + 1 && nums[k] != nums[k - 1])){
                               if(nums[k] + nums[j] + nums[i] == 0){
                                   list = new ArrayList<>();
                                   list.add(nums[i]);
                                   list.add(nums[j]);
                                   list.add(nums[k]);
                                   result.add(list);
                                   break;
                               }
                           }
                       }
                   }
               }
           }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(test).toString());
    }
}
