package leetcode.Three.minPatches;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020/12/29 下午2:24
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class minPatches {
    /**
     * 输入: nums = [1,5,10], n = 20
     * 输出: 2
     * 解释: 我们需要添加 [2, 4]。
     * 思路：
     * 1、补全数集，即[1,2,3,4,5,6,7....,20]
     * 2、删除nums能表达的数,剩余[2,3,4,7,8,9,12,13,14,17,18,19,20]
     * 3、[1,5,10]新增2，剩余[4,9,14,19,20]         [2,7,12,17,20]
     * 4、[1,2,5,10]新增4，剩余[]
     */
    public static int minPatches(int[] nums, int n) {
        int result = 0;
        // 需要补充的数字集合
        Set<Integer> totalNums = new HashSet<>();
        for(int i = 1; i <= n; i++){
            totalNums.add(i);
        }
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            temp.add(nums[i]);
        }
        Set<Integer> sums = numsSum(temp);
        for(Integer integer : sums){
            totalNums.remove(integer);
        }
        while (totalNums.size() != 0){
            result++;
            temp.add((int)totalNums.toArray()[0]);
            sums = numsSum(temp);
            for(Integer integer : sums){
               totalNums.remove(integer);
            }
        }
        return result;
    }

    public static Set<Integer> numsSum(List<Integer> array){
        Set<Integer> result = new HashSet<>();
        if(array.size() == 0){
            return result;
        }
        if(array.size() == 1){
            result.add(array.get(0));
            return result;
        }
        int first = array.get(0);
        result.add(first);
        array.remove(0);
        Set<Integer> temp = numsSum(array);
        for(Integer integer : temp){
            result.add(integer);
            result.add(first + integer);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[0];
        System.out.println(minPatches(nums,7));
    }
}
