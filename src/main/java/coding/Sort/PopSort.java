package coding.Sort;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/19 下午2:36
 * @desc 冒泡排序
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class PopSort {
    public int[] sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

}
