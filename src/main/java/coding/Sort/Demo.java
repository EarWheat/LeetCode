package coding.Sort;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/4/21 10:00 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/21 10:00 上午     liuzhaolu       firstVersion
 */
public class Demo {

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right || right >= nums.length || left < 0) {
            return;
        }
        int temp = nums[left];
        int index = left;
        while (left < right) {
            while (left < right && nums[right] >= temp) right--;
            while (left < right && nums[left] <= temp) left++;
            swap(nums, left, right);
        }
        swap(nums, index, left);
    }


    public void swap(int[] nums, int left, int right) {

    }

    public static void main(String[] args) {
        String s = "12345678";
        System.out.println(s.substring(1, 4));
        System.out.println(s.substring(4, 6));
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 1, 4)));
    }
}
