package leetcode.One.Thousand.heightChecker;

import java.util.Arrays;

/**
 * @Desc: https://leetcode.cn/problems/height-checker/
 * @Author: 泽露
 * @Date: 2022/6/13 4:18 PM
 * @Version: 1.initial version; 2022/6/13 4:18 PM
 */
public class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != expected[i]){
                result++;
            }
        }
        return result;
    }
}
