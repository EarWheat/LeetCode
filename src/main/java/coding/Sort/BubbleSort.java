package coding.Sort;

import java.util.Arrays;

/**
 * @author liuzhaolu
 * @version create_time：2018/8/1 类说明:冒泡排序
 */
public class BubbleSort {


    //从小到大排序
    public Integer[] BubbleSort(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
        }
        return array;
    }

    public void BubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void showArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
//        Integer array[] = {23, 45, 11, 18, 45, 66, 78};
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.showArray(array);
//        System.out.println();
//        bubbleSort.showArray(bubbleSort.BubbleSort(array));
        int[] nums = new int[]{23, 45, 11, 18, 45, 66, 78};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.BubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
