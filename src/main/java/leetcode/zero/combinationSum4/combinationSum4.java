package leetcode.zero.combinationSum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-11 16:11
 * @desc
 * @prd Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class combinationSum4 {
    public static int combinationSum4(int[] nums, int target) {
        List<List<Integer>> result = combinationSum(nums,target);
        return result.size();
    }

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
        int result = 0;
        result = combinationSum4(new int[]{1,2,3},4);
        result = combinationSum4(new int[]{2,3,6,7},7);
        result = combinationSum4(new int[]{2,3,5},8);
        System.out.println(result);
    }
}
