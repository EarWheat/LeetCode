package leetcode.Six.checkPossibility;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/7 下午2:17
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean transformed = false;    // 是否转换过
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]){
                if(transformed){
                    return false;
                } else {    // 没有转换过
                    // 需要考虑转换本数，还是后面的数
                    if(i > 0){ // 第一个数转换本数，不影响后面的数
                        if(nums[i + 1] < nums[i - 1]){
                            nums[i + 1] = nums[i];
                        }
                    }
                    transformed = true;
                }
            }
        }
        return true;
    }
}
