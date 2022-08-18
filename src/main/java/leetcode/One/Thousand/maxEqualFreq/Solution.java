package leetcode.One.Thousand.maxEqualFreq;

import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/18 11:33 AM
 * @Version: 1.initial version; 2022/8/18 11:33 AM
 */
public class Solution {
    public int maxEqualFreq(int[] nums) {
        if(nums.length == 2){
            return 2;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(n -> {
            map.put(n, map.getOrDefault(n, 0) + 1);
        });
        for (int i = nums.length - 1; i >= 0; i--) {
            if (isValid(map)) {
                return i + 1;
            }
            if(map.get(nums[i]) == 1){
                map.remove(nums[i]);
            } else {
                map.put(nums[i], map.get(nums[i]) - 1);
            }
        }
        return -1;
    }

    public boolean isValid(Map<Integer, Integer> map) {
        if (map.size() == 1) {
            return true;
        }
        Integer temp = null;
        Integer onlyOne = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(onlyOne > 1){
                break;
            }
            if(temp != null){
                if(Math.abs(temp - entry.getValue()) == 1 ||
                        (entry.getValue() == 1 && !temp.equals(entry.getValue()))){
                    onlyOne++;
                    continue;
                }
            }
            temp = entry.getValue();
        }
        return onlyOne == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxEqualFreq(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}
