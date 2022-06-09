package leetcode.Four.rectsRandomPick;

import java.util.Random;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/9 3:25 PM
 * @Version: 1.initial version; 2022/6/9 3:25 PM
 */
public class Solution {

    int[][] rescts;

    public Solution(int[][] rects) {
        this.rescts = rects;
    }

    public int[] pick() {
        Random random = new Random();
        // 选择某一个长方形
        int index = random.nextInt(rescts.length);
        int[] rect = rescts[index];
        int len = rect[0] + random.nextInt(rect[2] + 1 - rect[0]);
        int high = rect[1] + random.nextInt(rect[3] + 1 - rect[1]);
        return new int[]{len, high};
    }


    public static void main(String[] args) {

    }
}
