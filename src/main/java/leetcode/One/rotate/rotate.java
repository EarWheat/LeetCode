package leetcode.One.rotate;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/8 上午11:40
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class rotate {
    /**
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     */
    public static void rotate(int[] nums, int k) {
        if(nums.length == 1){
            return;
        }
        if(k > nums.length){
            k = k % nums.length;
        }
        for(int i = 0; i < k; i++){
            int temp = nums[nums.length - 1];
            for(int j = 0; j < nums.length - 1; j++){
                nums[nums.length - 1 - j] = nums[nums.length - 1 - j - 1];
            }
            nums[0] = temp;
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println(JSONObject.toJSONString(nums));
    }
}
