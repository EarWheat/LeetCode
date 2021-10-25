package leetcode.One.Thousand.allCellsDistOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-17 17:49
 * @desc 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 *  
 *
 * 示例 1：
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 *
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 *
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *  
 *
 * 提示：
 *
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 *
 *
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class allCellsDistOrder {
    /**
     *  * 输入：R = 2, C = 3, r0 = 1, c0 = 2
     *  * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
     *  * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
     *  * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
     * @param R
     * @param C
     * @param r0
     * @param c0
     * [# # #]
     * [# # *]
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0));
            }
        });
        return ret;

    }

    public List<int[]> getRoadWay(List<int[]> originLocation, int R, int C, boolean[][] visited){
        List<int[]> result = new ArrayList<>();
        return result;
    }

    public List<int[]> mostRelation(int[] location, int R, int C, boolean[][] visited){
        List<int[]> result = new ArrayList<>();
        result.add(location);
        int r = location[0];
        int c = location[1];
        // 下移
        if(r + 1 < R && !visited[r + 1][c]){
            result.add(new int[]{r + 1,c});
        }
        // 右移
        if(c + 1 < C && !visited[r][c + 1]){
            result.add(new int[]{r,c + 1});
        }
        // 上移
        if(r - 1 >= 0 && !visited[r - 1][c]){
            result.add(new int[]{r - 1, c});
        }
        // 左移
        if(c - 1 >= 0 && !visited[r][c - 1]){
            result.add(new int[]{r,c - 1});
        }
        return result;
    }
}
