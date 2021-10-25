package leetcode.Zero.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-20 15:29
 * @desc
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = subsets2(nums);
        result.add(new ArrayList<>());
        return result;
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        // 每新增一个数集合新增的可能情况
        List<Integer> newSets = new ArrayList<>();
        // 该值本身
        newSets.add(nums[nums.length - 1]);
        result.add(newSets);
        List<List<Integer>> subList = subsets2(Arrays.copyOfRange(nums,0,nums.length - 1));
        result.addAll(subList);
        for(List<Integer> list : subList){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(nums[nums.length - 1]);
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> temp = subsets(new int[]{1,2,3});
        System.out.println(temp.toString());
    }
}
