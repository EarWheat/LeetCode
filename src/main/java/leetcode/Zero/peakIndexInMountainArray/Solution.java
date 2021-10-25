package leetcode.Zero.peakIndexInMountainArray;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/14 5:30 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;
        while (left <= right){
            int middle = (left + right) / 2;
            if(middle == 0 || middle == arr.length){
                return -1;
            }
            if(left == right){
                return left;
            }
            if(arr[middle] > arr[middle - 1] && arr[middle] > arr[middle + 1]){
                return middle;
            }
            if(arr[middle] > arr[middle - 1] && arr[middle] < arr[middle + 1]){
                left = middle;
            }
            if(arr[middle] < arr[middle - 1] && arr[middle] > arr[middle + 1]){
                right = middle;
            }
        }
        return -1;
    }
}
