package leetcode.History.numIslands;

import UtilClass.ShowArray;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-20 19:02
 * @desc:给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

示例 1:

输入:
11110
11010
11000
00000
输出: 1
示例 2:

输入:
11000
11000
00100
00011
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

* 111
* 010
* 111
*
 */
public class numIslands extends ShowArray {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] grid3 = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
//        int result = numIslands(grid);
//        System.out.println(result);
//        int result2 = numIslands(grid2);
//        System.out.println(result2);
        int result3 = numIslands(grid3);
        System.out.println(result3);
    }

    public static int numIslands(char[][] grid) {
        char mark = 'a';
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    island(grid, i, j, mark++);
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        return mark - 'a';
    }

    /**
     * * 111
     * * 010
     * * 111
     */
    private static void island(char[][] grid,int x, int y, char mark){
        if(grid[x][y] == '1'){
            grid[x][y] = mark;
            if(x < grid.length - 1){
                if(grid[x + 1][y] != mark){
                    island(grid,x + 1, y, mark);
                }
            }
            if(x >= 1){
                if(grid[x - 1][y] != mark){
                    island(grid,x - 1, y, mark);
                }
            }
            if(y < grid[0].length - 1){
                if(grid[x][y + 1] != mark){
                    island(grid, x, y + 1, mark);
                }
            }
            if(y >= 1){
                if(grid[x][y - 1] != mark){
                    island(grid, x, y - 1, mark);
                }
            }
        }
    }
}
