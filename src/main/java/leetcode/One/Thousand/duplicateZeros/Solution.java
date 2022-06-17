package leetcode.One.Thousand.duplicateZeros;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/17 11:31 AM
 * @Version: 1.initial version; 2022/6/17 11:31 AM
 */
public class Solution {
    // 1,0,0,2,3,0,4,5,0

    // |
    // 1,0,0,2,3,0,4,5,0     q = null

    //   |
    // 1,0,0,2,3,0,4,5,0     q = 0

    //       |
    // 1,0,0,0,3,0,4,5,0     temp = 2

    // 1,0,0,0,0,2,3,0,0
    public void duplicateZeros(int[] arr) {
        int i = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        while (i < arr.length) {
            if (queue.size() != 0) {
                queue.add(arr[i]);
                arr[i] = queue.poll();
            }
            if (arr[i] == 0 && i + 1 < arr.length) {
                queue.add(arr[i + 1]);
                arr[i + 1] = 0;
                i++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(array);
        System.out.println(Arrays.toString(array));
    }
}
