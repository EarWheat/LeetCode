package leetcode.One.Thousand.shiftGrid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/20 10:15 AM
 * @Version: 1.initial version; 2022/7/20 10:15 AM
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int length = grid.length * grid[0].length;
        int gap = k % length;
        int columnNum = grid[0].length;
        List<Integer> gridList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gridList.add(grid[i][j]);
            }
        }
        List<Integer> gapList = gridList.subList(gridList.size() - gap, gridList.size());
        List<Integer> temp = new ArrayList<>();
        int i = 0;
        while (i < gapList.size()){
            if(temp.size() < columnNum){
                temp.add(gapList.get(i));
                i++;
            } else {
                result.add(temp);
                temp = new ArrayList<>();
            }
        }
        i = 0;
        while (i < gridList.size() - gap){
            if(temp.size() < columnNum){
                temp.add(gridList.get(i));
                i++;
            } else {
                result.add(temp);
                temp = new ArrayList<>();
            }
        }
        result.add(temp);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shiftGrid(new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}}, 5));
    }

}
