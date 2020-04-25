package test;

/**
 * @author liuzhaolu
 * @version create_time：2018/9/1 类说明:
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++){
            result[0] = i;
            int add = target - nums[i];
            int j = i+1;
            for(j = i+1;j<nums.length;j++){
                if(nums[j] == add){
                    result[1] = j;
                    break;
                } else {
                    continue;
                }
            }
            if(j == nums.length){
                continue;
            } else {
                break;
            }
        }
        return result;
    }
}
