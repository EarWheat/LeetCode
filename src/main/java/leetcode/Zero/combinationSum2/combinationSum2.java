package leetcode.Zero.combinationSum2;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-10 16:29
 * @desc
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 *
 * @prd Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class combinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0 || target == 0){
            return result;
        }
        Arrays.sort(candidates);
        if(candidates[0] > target){
            return result;
        }
        // 只有一个数时
        if(candidates.length == 1){
            // 刚好能用该数构成target
            if(target == candidates[0]){
                List<Integer> temp = new ArrayList<>();
                temp.add(candidates[0]);
                result.add(temp);
            }
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
                result.add(temp);
            }
            List<List<Integer>> lastCombination = combinationSum2(Arrays.copyOfRange(candidates,0,i), target - subNum);
            for(List<Integer> combination : lastCombination){
                combination.add(subNum);
                result.add(combination);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
//        result = combinationSum2(new int[]{2,3,6,7},7);
//        result = combinationSum2(new int[]{2,3,5},8);
        result = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        result = combinationSum2(new int[]{2,5,2,1,2},5);
        System.out.println(result.toString());
    }
}
