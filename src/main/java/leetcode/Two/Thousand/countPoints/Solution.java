package leetcode.Two.Thousand.countPoints;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/11/2 2:39 PM
 * @Version: 1.initial version; 2023/11/2 2:39 PM
 */
public class Solution {
    static final int POLE_NUM = 10;
    static final int COLOR_NUM = 3;

    public int countPoints(String rings) {
        int[][] state = new int[POLE_NUM][COLOR_NUM];
        int n = rings.length();
        for (int i = 0; i < n; i += 2) {
            char color = rings.charAt(i);
            int poleIndex = rings.charAt(i + 1) - '0';
            state[poleIndex][getColorId(color)] = 1;
        }
        int res = 0;
        for (int i = 0; i < POLE_NUM; i++) {
            boolean flag = true;
            for (int j = 0; j < COLOR_NUM; j++) {
                if (state[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }

    public int getColorId(char color) {
        if (color == 'R') {
            return 0;
        } else if (color == 'G') {
            return 1;
        }
        return 2;
    }
}