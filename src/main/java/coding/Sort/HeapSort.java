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

    /**
     * 构建堆
     * @param nums
     */
    public void buildHeap(int[] nums, int i){
        if(i >= nums.length || i <= 1){
            return;
        }
        int temp = nums[i];
        int parentIndex = i / 2 - 1;
        while (temp > nums[parentIndex]){
            swap(nums, i, i / 2);
            parentIndex = parentIndex / 2;
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

        for (int i = 1; i < nums.length; i++) {
            heapSort.buildHeap(nums, i);
        }
        System.out.println(Arrays.toString(nums));
    }
}
