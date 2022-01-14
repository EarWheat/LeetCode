package leetcode.Util;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：堆
 * @prd :
 * @date ：2022/1/14 5:14 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/14 5:14 下午     liuzhaolu       firstVersion
 */
public class Heap {

    public int[] array;

    Heap(int[] array){
        this.array = array;
    }

    // 构建大顶堆
    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] get(){
        return array;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,5,3,8,7,6};
        Heap heap = new Heap(nums);
        System.out.println(Arrays.toString(heap.get()));
    }
}
