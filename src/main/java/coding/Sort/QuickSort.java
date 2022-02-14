package coding.Sort;

import java.util.Arrays;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-23 14:04
 * @desc:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{23, 45, 11, 18, 45, 66, 78};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        int index = left;
        int temp = nums[index];
        while (left < right) {
            while (left < right && nums[right] >= temp) right--;
            while (left < right && nums[left] <= temp) left++;
            swap(nums, left, right);
        }
        swap(nums, index, left);
        quickSort(nums, 0, left - 1);
        quickSort(nums, left + 1, right);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
//    public static void sort(int[] a, int low, int high){
//        if(low >= high){
//            return;
//        }
//
//        int left = low;
//        int right = high;
//
//        // 保存基准值
//        int index = a[left];
//        while (left < right){
//            // 从后向前找比基准小的元素
//            while (left < right && a[right] >= index){
//                right--;
//            }
//            a[left] = a[right];
//            // 从前往后找比基准大的元素
//            while (left < right && a[left] <= index){
//                left++;
//            }
//            a[right] = a[left];
//        }
//        a[left] = index;
//        sort(a, low, left - 1);
//        sort(a, left + 1, high);
//    }

}
