package coding.Sort;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：堆排序
 * @prd :
 * @date ：2022/2/10 5:46 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/10 5:46 下午     liuzhaolu       firstVersion
 */
public class HeapSort {


    public void sort(int[] nums){
        buildHeap(nums);
        int len = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            len--;
            heapify(nums,0, len);
        }
    }
    /**
     * 构建堆
     */
    public void buildHeap(int[] nums){
        for (int i = (int) Math.floor (nums.length / 2); i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
    }

    public void heapify(int[] nums, int i, int len){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if(left < len && nums[left] > nums[largest]){
            largest = left;
        }
        if(right < len && nums[right] > nums[largest]){
            largest = right;
        }
        if(largest != i){
            swap(nums, i, largest);
            heapify(nums, largest, len);
        }
    }

    /**
     * 交换数组位置
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
