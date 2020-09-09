package leetcode.zero.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-09 10:57
 * @desc 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * @prd Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class combinationSum {
    /**
     * 思路：
     * 如果只有一个数，可以看看能否直接通过重复的方式组成target，即判定target % candidates[0] == 0
     * 如果多于n个数时，我用例子candidates = [2,3,6,7], target = 7讲解
     * step1:排序
     * 用最后一个7组成target。则newTarget = 7 - 7 = 0
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if(target % candidates[0] == 0){
                List<Integer> temp = new ArrayList<>();
                int sum = 0;
                while (sum < target){
                    sum = sum + candidates[0];
                    temp.add(candidates[0]);
                }
                result.add(temp);
            }
            return result;
        }
        // 大于一个数时
        // 用前n-1个数的和
        for(int i = candidates.length - 1; i >= 0; i--){
            int subNum = candidates[i];
            // 记录用了多少次第n个数
            List<Integer> lastNumList = new ArrayList<>();
            int tempTarget = target;
            while (tempTarget > 0){
                tempTarget = tempTarget - subNum;
                if(tempTarget < 0){
                    break;
                }
                lastNumList.add(subNum);
                if(tempTarget == 0){
                    result.add(lastNumList);
                    break;
                }
                List<List<Integer>> lastCombination = combinationSum(Arrays.copyOfRange(candidates,0,i), tempTarget);
                for(List<Integer> combination : lastCombination){
                    combination.addAll(lastNumList);
                    result.add(combination);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result = combinationSum(new int[]{2,3,6,7},7);
        result = combinationSum(new int[]{2,3,5},8);
        System.out.println(result.toString());
    }
}
