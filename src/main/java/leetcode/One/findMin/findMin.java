package leetcode.One.findMin;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/8 下午4:16
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class findMin {
    // 1,2,3,4,5
    // 5,1,2,3,4
    // 4,5,1,2,3
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if(right - left == 1){
                return Math.min(nums[left],nums[right]);
            }
            int middle = (left + right) / 2;
            if(nums[left] <= nums[middle] && nums[middle] <= nums[right]){
                return nums[left];
            }
            if(nums[left] >= nums[middle]){
                right = middle;
                continue;
            }
            if(nums[middle] >= nums[right]){
                left = middle;
                continue;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5,1,2,3,4}));
    }
}
