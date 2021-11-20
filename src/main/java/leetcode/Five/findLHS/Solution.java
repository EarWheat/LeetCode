package leetcode.Five.findLHS;

import java.util.*;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/20 3:36 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/20      liuzhaolu       firstVersion
 */
public class Solution {
    public int findLHS(int[] nums) {
        int result = 0;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        Arrays.sort(nums);
        Arrays.stream(nums).forEach(n -> {
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        });
        for (int i = 1; i < nums.length; i++) {
            if(Math.abs(nums[i] - nums[i - 1]) == 1){
                result = Math.max(result, map.get(nums[i]) + map.get(nums[i - 1]));
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,2,5,2,3,7};
        Solution solution = new Solution();
        System.out.println(solution.findLHS(array));
    }
}
