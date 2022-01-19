package leetcode.Two.containsNearbyDuplicate;

import sun.misc.Queue;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ：liuzhaolu
 * @description：219. 存在重复元素 II
 * @prd : https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @date ：2022/1/19 2:55 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/19 2:55 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0){
            return false;
        }
        LinkedHashSet<Integer> window = new LinkedHashSet<>();
        for (int i = 0; i < Math.min(nums.length, k); i++) {
            if(window.contains(nums[i])){
                return true;
            } else {
                window.add(nums[i]);
            }
        }
        int temp = nums[0];
        for (int i = k; i < nums.length; i++) {
            if(window.contains(nums[i])){
                return true;
            } else {
                window.remove(temp);
                temp = nums[i - k + 1];
                window.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,9};
        System.out.println(solution.containsNearbyDuplicate(nums,3));
    }
}
