package leetcode.Four.findDuplicates;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/8 11:14 AM
 * @Version: 1.initial version; 2022/5/8 11:14 AM
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] n = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[nums[i] - 1] ++;
        }
        for (int i = 0; i < n.length; i++) {
            if(n[i] > 1){
                result.add(i + 1);
            }
        }
        return result;
    }
}
