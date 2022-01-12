package leetcode.Three.increasingTriplet;

/**
 * @author ：liuzhaolu
 * @description：334. 递增的三元子序列
 * @prd : https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 * @date ：2022/1/12 11:36 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/12 11:36 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        int i = 0,j = 0,k = 0;
        while (i <= nums.length - 3){
            j = i;
            k = i;
            for (int index = i + 1; index < nums.length; index++){
                // 定位k
                if(nums[index] > nums[j]){
                    k = index;
                    // 定位j
                    while (j < k){
                        if(nums[j] > nums[i] && nums[j] < nums[k]){
                            return true;
                        }
                        j++;
                    }
                    j = i;
                }
            }
            // 移动i
            boolean iMove = false;
            for (int l = i; l < nums.length; l++) {
                if(nums[l] < nums[i]){
                    i = l;
                    iMove = true;
                    break;
                }
            }
            if(!iMove){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(new int[]{4,5,2147483647,1,2}));
    }
}
