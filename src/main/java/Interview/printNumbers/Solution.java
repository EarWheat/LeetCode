package Interview.printNumbers;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/10 6:22 PM
 * @Version: 1.initial version; 2022/7/10 6:22 PM
 */
public class Solution {
    public int[] printNumbers(int n) {
        int length = (int) (Math.pow(10, n) - 1);
        int[] result = new int[length];
        for (int i = 1; i <= length; i++) {
            result[i - 1] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.printNumbers(3)));
    }
}
