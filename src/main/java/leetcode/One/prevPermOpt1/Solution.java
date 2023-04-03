package leetcode.One.prevPermOpt1;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/4/3 5:48 PM
 * @Version: 1.initial version; 2023/4/3 5:48 PM
 */
public class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = n - 1;
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j--;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                break;
            }
        }
        return arr;
    }
}
