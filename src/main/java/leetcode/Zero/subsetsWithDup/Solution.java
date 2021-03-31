package leetcode.Zero.subsetsWithDup;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/31 上午7:28
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    // [1]  ->     [],[1]
    // [1,2]    ->  [],[1],[2],[1,2]
    // [1,2,3]  ->  [],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        retList.add(new ArrayList<>());
        if(nums == null || nums.length == 0) return retList;
        Arrays.sort(nums);


        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        retList.add(tmp);
        if(nums.length == 1) return retList;

        int lastLen = 1;

        for(int i = 1; i < nums.length; i++){
            int size = retList.size();
            if(nums[i] != nums[i-1]){
                lastLen = size;
            }

            for(int j = size - lastLen; j < size; j++){
                List<Integer> inner = new ArrayList(retList.get(j));
                inner.add(nums[i]);
                retList.add(inner);
            }
        }
        return retList;
    }

    // [1]  ->     [],[1]
    // [1,2]    ->  [],[1],[2],[1,2]
    // [1,2,2]  ->  [],[1],[2],[1,2]        [1,2,2],[2,2]
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
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.subsetsWithDup(new int[]{1,2,2})));
    }
}
