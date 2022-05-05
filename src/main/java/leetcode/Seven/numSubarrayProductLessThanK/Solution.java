package leetcode.Seven.numSubarrayProductLessThanK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/5 4:34 PM
 * @Version: 1.initial version; 2022/5/5 4:34 PM
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums.length == 0 || k == 0){
            return 0;
        }
        if (nums.length == 1 && nums[0] < k) {
            return 1;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = getSubarray(nums, i, nums.length, k);
            resultList.addAll(temp);
        }
        System.out.println(resultList);
        return resultList.size();
    }

    public List<List<Integer>> getSubarray(int[] nums, int i, int j, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (j - i == 1) {
            List<Integer> temp = new ArrayList<>();
            if(nums[i] < k){
                temp.add(nums[i]);
                resultList.add(temp);
            }
            return resultList;
        }
        List<List<Integer>> tempResult = getSubarray(nums, i, j - 1, k);
        resultList.addAll(tempResult);
        int lastNum = nums[j - 1];
        for (List<Integer> list : tempResult) {
            if (list.get(list.size() - 1) == nums[j - 2]) {
                List<Integer> temp = new ArrayList<>(list);
                Integer multi = 1;
                for(Integer integer : temp){
                    multi = integer * multi;
                }
                if(multi * lastNum < k){
                    temp.add(lastNum);
                    resultList.add(temp);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,7,3};
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(nums, 25));
    }

}
