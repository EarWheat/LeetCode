package leetcode.permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-25 08:46
 * @desc:给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

* 思路：
* 递归求解，排列1，2，3。则是1开头，2，3的所有排列。2开头，1，3所有排列
* 若是排列1，2，3，4。则是1开头，2，3，4所有排列
 */
public class permute {


    public static void main(String[] args) {
        int[] test = {1,2,3};
        System.out.println(permute(test));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(nums.length == 1){
            temp.add(nums[0]);
            result.add(temp);
            return result;
        }
        for(int i = 0; i < nums.length; i++){
            int[] tempNums = remove(nums,i);
            List<List<Integer>> pailie = permute(tempNums);
            for(List<Integer> p : pailie){
                p.add(nums[i]);
                result.add(p);
            }
        }
        return result;
    }

    private static List<List<Integer>> getList(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(nums.length == 1){
            temp.add(nums[0]);
            result.add(temp);
            return result;
        }
        for(int i = 0; i < nums.length; i++){
            int[] tempNums = remove(nums,i);
            List<List<Integer>> pailie = getList(tempNums);
            for(List<Integer> p : pailie){
                p.add(nums[i]);
                result.add(p);
            }
        }
        return result;
    }

    // int[]转List
    private static List<Integer> nums2List(int[] nums){
        List<Integer> result = new ArrayList<>();
        for(int i : nums){
            result.add(i);
        }
        return result;
    }

    private static int[] remove(int[] nums, int index){
        int[] result = new int[nums.length-1];
        int j = 0;
        for(int i = 0; i < index; i++){
            result[j++] = nums[i];
        }
        for(int i = index + 1; i < nums.length; i++){
            result[j++] = nums[i];
        }
        return result;
    }

    private static void showAway(List<Integer> list){
        for(int i =0; i < list.size();i++){
            System.out.print(list.get(i));
        }
        System.out.println();
    }
}
