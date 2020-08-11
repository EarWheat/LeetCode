package leetcode.solve;

import java.util.LinkedList;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-11 16:18
 * @desc:
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class solve {
    /**
     * 思路：
     * 遍历一遍所有的点，记录边界O的位置，并将所有点置为X
     * 从边界O向里替换。
     * @param board
     */
    public static void solve(char[][] board) {
        if(board.length == 0){
            return;
        }
        boolean[][] record = new boolean[board.length][board[0].length];
        boolean[][] isReplaced = new boolean[board.length][board[0].length];
        // 遍历O的边界位置往里覆盖
        for (int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O'){
                replace(0,i,board,record,isReplaced);
            }
        }
        for (int i = 0; i < board[0].length;i++){
            if(board[board.length - 1][i] == 'O'){
                replace(board.length - 1,i,board,record,isReplaced);
            }
        }
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                replace(i,0,board,record,isReplaced);
            }
        }
        for(int i = 0; i < board.length; i++){
            if(board[i][board[0].length - 1] == 'O'){
                replace(i,board[0].length - 1,board,record,isReplaced);
            }
        }
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                if(record[i][j]){
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void replace(int i, int j, char[][] board, boolean[][] record, boolean[][] isReplaced){
        // 该点为O
        record[i][j] = true;
        isReplaced[i][j] = true;
        // 下
        if(i + 1 < board.length){
            // 下面相邻的节点是O且未被替换过
            if(board[i+1][j] == 'O' && !isReplaced[i+1][j]){
                isReplaced[i + 1][j] = true;
                replace(i+1,j,board,record,isReplaced);
            }
        }
        // 上
        if(i - 1 >= 0){
            // 上面相邻的节点是O且未被替换过
            if(board[i - 1][j] == 'O' && !isReplaced[i - 1][j]){
                isReplaced[i - 1][j] = true;
                replace(i - 1,j,board,record,isReplaced);
            }
        }
        // 左
        if(j - 1 >= 0){
            // 左面相邻的节点是O且未被替换过
            if(board[i][j - 1] == 'O' && !isReplaced[i][j - 1]){
                isReplaced[i][j - 1] = true;
                replace(i,j - 1,board,record,isReplaced);
            }
        }
        // 右
        if(j + 1 < board[0].length){
            // 右面相邻的节点是O且未被替换过
            if(board[i][j + 1] == 'O' && !isReplaced[i][j + 1]){
                isReplaced[i][j + 1] = true;
                replace(i,j + 1,board,record,isReplaced);
            }
        }
    }


    public static void main(String[] args) {
        /*
        X X X X
        X O O X
        X X O X
        X O X X
         */

        char[][] test = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(test);
        System.out.println(test.toString());
    }
}
