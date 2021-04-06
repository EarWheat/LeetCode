package leetcode.Zero.removeDuplicates;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/6 上午7:56
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int repeat = 1; // 重复次数;
        int index = 1; // 指针；
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]){
                repeat++;
                if(repeat <= 2){
                    nums[index++] = nums[i];
                }
            } else {
                nums[index++] = nums[i];
                repeat = 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
//        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
