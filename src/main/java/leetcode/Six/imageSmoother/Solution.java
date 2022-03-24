package leetcode.Six.imageSmoother;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/3/24 2:00 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/24 2:00 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int[][] imageSmoother(int[][] img) {
        if (img.length < 1) {
            return null;
        }
        int[][] result = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                int temp = img[i][j];
                int num = 1;
                if (i - 1 >= 0) {
                    temp += img[i - 1][j]; // 上
                    num++;
                    if (j - 1 >= 0) {
                        temp += img[i - 1][j - 1]; // 左上
                        num++;
                    }
                    if (j + 1 < img[i].length) {
                        temp += img[i - 1][j + 1]; // 右上
                        num++;
                    }
                }
                if (j - 1 >= 0) {
                    temp += img[i][j - 1];  // 左
                    num++;
                }
                if (j + 1 < img[i].length) {
                    temp += img[i][j + 1];
                    num++;
                }
                if (i + 1 < img.length) {
                    temp += img[i + 1][j]; // 下
                    num++;
                    if (j - 1 >= 0) {
                        temp += img[i + 1][j - 1]; // 左下
                        num++;
                    }
                    if (j + 1 < img[i].length) {
                        temp += img[i + 1][j + 1]; // 右下
                        num++;
                    }
                }
                result[i][j] = temp / num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.imageSmoother(new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}})));
    }
}
