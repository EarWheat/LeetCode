package leetcode.findSubsequences;

import java.util.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-25 09:50
 * @desc:给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
说明:

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。

 */
public class findSubsequences {
    /**
     * 递归
     * @param nums
     * @return
     */
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length <= 1){
            return result;
        }
        if(nums.length == 2){
            List<Integer> temp = new ArrayList<>();
            if(nums[0] <= nums[1]){
                temp.add(nums[0]);
                temp.add(nums[1]);
                result.add(temp);
            }
            return result;
        }
        Set<List<Integer>> setList = new HashSet<>();
        int last = nums[nums.length - 1];
        for(int i = 0; i < nums.length;i++){
            List<Integer> temp = new ArrayList<>();
            if(last >= nums[i]){
                temp.add(nums[i]);
                temp.add(last);
                if(!setList.contains(temp)){
                    setList.add(temp);
                    result.add(temp);
                }
            }
        }
        List<List<Integer>> oldList = findSubsequences(Arrays.copyOfRange(nums,0,nums.length - 1));
        result.addAll(oldList);
        for(List<Integer> list : oldList){
            if(last >= list.get(list.size() - 1)){
                List<Integer> t = new ArrayList<>(list);
                t.add(last);
                if(!setList.contains(t)){
                    setList.add(t);
                    result.add(t);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = findSubsequences(new int[]{4,6,7,7});
        System.out.println(result.toString());
    }
}
