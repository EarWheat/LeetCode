package leetcode.Six.findClosestElements;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 658 找到K个最接近的元素
 * @Author: 泽露
 * @Date: 2022/8/25 4:59 PM
 * @Version: 1.initial version; 2022/8/25 4:59 PM
 */
public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Double res = (double)5789 / (double)100;
        System.out.println(res);
        System.out.printf("%.2f", Math.floor(res) / 100);
    }
}
