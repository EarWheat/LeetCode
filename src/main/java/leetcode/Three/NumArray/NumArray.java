package leetcode.Three.NumArray;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/1 下午2:25
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class NumArray {
    public int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int result = 0;
        for (int k = i; k <= j; k++) {
            result+= nums[k];
        }
        return result;
    }

}
