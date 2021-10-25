package leetcode.Nine.numSubarraysWithSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/8 下午4:32
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-goal)){
                res += map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,0};
        Solution solution = new Solution();
        System.out.println(solution.numSubarraysWithSum(nums, 0));
    }
}
