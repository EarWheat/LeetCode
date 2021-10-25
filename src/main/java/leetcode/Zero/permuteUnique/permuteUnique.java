package leetcode.Zero.permuteUnique;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-18 17:29
 * @desc
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class permuteUnique {
    /**
     * 思路：
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        if(nums.length == 1){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[0]);
            result.add(temp);
            return result;
        }
        Set<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if (hashSet.contains(nums[i])){
                continue;
            } else {
                hashSet.add(nums[i]);
            }
            List<List<Integer>> temp = permuteUnique(newNums(nums,i));
            for(List<Integer> list : temp){
                list.add(nums[i]);
                result.add(list);
            }
        }
        return result;
    }

    // 去除掉第i个元素
    private static int[] newNums(int[] num, int index){
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < num.length;i++){
            if(i != index){
                temp.add(num[i]);
            }
        }
        return temp.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
        System.out.println("hello");
    }
}
