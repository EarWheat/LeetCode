package leetcode.Eight.peakIndexInMountainArray;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/15 下午3:28
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length == 1){
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if(arr[middle - 1] < arr[middle] && arr[middle] > arr[middle + 1]){
                return middle;
            }
            if(arr[middle - 1] < arr[middle] && arr[middle] < arr[middle + 1]){
                left = middle;
            }
            if(arr[middle - 1] > arr[middle] && arr[middle] > arr[middle + 1]){
                right = middle;
            }
        }
        return left;
    }

}
