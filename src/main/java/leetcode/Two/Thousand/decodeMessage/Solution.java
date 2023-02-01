package leetcode.Two.Thousand.decodeMessage;
//如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
//
//
// 矩阵对角线上的所有元素都 不是 0
// 矩阵中所有其他元素都是 0
//
//
// 给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false
//。
//
//
//
// 示例 1：
//
// 输入：grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
//输出：true
//解释：矩阵如上图所示。
//X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
//因此，grid 是一个 X 矩阵。
//
//
// 示例 2：
//
// 输入：grid = [[5,7,0],[0,3,1],[0,5,0]]
//输出：false
//解释：矩阵如上图所示。
//X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
//因此，grid 不是一个 X 矩阵。
//
//
//
//
// 提示：
//
//
// n == grid.length == grid[i].length
// 3 <= n <= 100
// 0 <= grid[i][j] <= 10⁵
//
// Related Topics 数组 矩阵 👍 24 👎 0

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/2/1 10:44 AM
 * @Version: 1.initial version; 2023/2/1 10:44 AM
 */
public class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> keyMap = new HashMap<>();
        char index = 'a';
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (!keyMap.containsKey(c)) {
                keyMap.put(c, index++);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c != ' ') {
                result.append(keyMap.get(message.charAt(i)));
            } else {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }

}
