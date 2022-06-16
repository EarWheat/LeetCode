package leetcode.Five.findPairs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/16 10:32 AM
 * @Version: 1.initial version; 2022/6/16 10:32 AM
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        Set<String> diffNums = new HashSet<>();
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            if (nums[j] == nums[i]) {
                if (k == 0 && !diffNums.contains(buildDiffNumStr(nums[i],nums[j]))) {
                    diffNums.add(buildDiffNumStr(nums[i],nums[j]));
                    result++;
                }
            } else {
                while (j < nums.length && nums[j] - nums[i] <= k) {
                    if(nums[j] == nums[j - 1]){
                        j++;
                        continue;
                    }
                    if (nums[j] - nums[i] == k) {
                        result++;
                    }
                    j++;
                }
            }
        }
        return result;
    }

    public String buildDiffNumStr(int i, int j){
        return i + "," + j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3));
    }
}
