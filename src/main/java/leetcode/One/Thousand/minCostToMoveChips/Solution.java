package leetcode.One.Thousand.minCostToMoveChips;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/8 3:25 PM
 * @Version: 1.initial version; 2022/7/8 3:25 PM
 */
public class Solution {
    // 计算奇数上的个数和偶数上的个数,取最小
    public int minCostToMoveChips(int[] position) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                a++;
            } else {
                b++;
            }
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {

    }
}
