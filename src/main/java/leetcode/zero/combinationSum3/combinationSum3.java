package leetcode.zero.combinationSum3;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-11 15:31
 * @desc
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @prd Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class combinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};
        return combinationSum2(candidates,k,n);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0 || target == 0){
            return result;
        }
        if(k == 0){
            return result;
        }
        Arrays.sort(candidates);
        if(candidates[0] > target){
            return result;
        }
        // 大于一个数时
        // 用前n-1个数的和
        Set<Integer> answerSet = new HashSet<>();
        for(int i = candidates.length - 1; i >= 0; i--){
            if(answerSet.contains(candidates[i])){
                continue;
            } else {
                answerSet.add(candidates[i]);
            }
            int subNum = candidates[i];
            if(subNum == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(subNum);
                if(temp.size() == k){
                    result.add(temp);
                }
            }
            List<List<Integer>> lastCombination = combinationSum2(Arrays.copyOfRange(candidates,0,i), k - 1,target - subNum);
            for(List<Integer> combination : lastCombination){
                combination.add(subNum);
                if(combination.size() == k){
                    result.add(combination);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
//        result = combinationSum2(new int[]{2,3,6,7},7);
//        result = combinationSum2(new int[]{2,3,5},8);
        result = combinationSum3(3,7);
        result = combinationSum3(3,9);
        result = combinationSum3(1,6);
        System.out.println(result.toString());
    }
}
