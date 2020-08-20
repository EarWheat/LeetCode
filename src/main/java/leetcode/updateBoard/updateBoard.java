package leetcode.updateBoard;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-20 17:32
 * @desc:让我们一起来玩扫雷游戏！

给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。

现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：

如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
如果在此次点击中，若无更多方块可被揭露，则返回面板。
 

* 示例 1：

输入:

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

输出:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

解释:

示例 2：

输入:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Click : [1,2]

输出:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

解释:

 

注意：

输入矩阵的宽和高的范围为 [1,50]。
点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
输入面板不会是游戏结束的状态（即有地雷已被挖出）。
简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。


 */
public class updateBoard {
    public static char[][] updateBoard(char[][] board, int[] click) {
        if(click == null || click.length < 2){
            return board;
        }
        int i = click[0];
        int j = click[1];
        boolean[][] visited = new boolean[board.length][board[0].length];
        // 点击到地雷
        if(board[i][j] == 'M'){
            visited[i][j] = true;
            board[i][j] = 'X';
            return board;
        }
        // 点击到空白
        if(board[i][j] == 'E'){
            board[i][j] = 'B';
            updateLocation(i,j,board,visited);
        }
        return board;
    }

    public static void updateLocation(int i , int j, char[][] board, boolean[][] visited){
        if(visited[i][j]){
            return;
        }
        visited[i][j] = true;
        // 周边雷的数量
        int numOfM = 0;
        // 左上
        if(i - 1 >= 0 && j >= 1){
            if(board[i - 1][j - 1] == 'M'){
                numOfM++;
            }
        }
        // 上
        if(i - 1 >= 0){
            if(board[i - 1][j] == 'M'){
                numOfM++;
            }
        }
        // 右上
        if(i - 1 >= 0 && j + 1 < board[0].length){
            if(board[i - 1][j + 1] == 'M'){
                numOfM++;
            }
        }
        // 右
        if(j + 1 < board[0].length){
            if(board[i][j + 1] == 'M'){
                numOfM++;
            }
        }
        // 右下
        if(i + 1 < board.length && j + 1 < board[0].length){
            if(board[i + 1][j + 1] == 'M'){
                numOfM++;
            }
        }
        // 下
        if(i + 1 < board.length){
            if(board[i + 1][j] == 'M'){
                numOfM++;
            }
        }
        // 左下
        if(i + 1 < board.length && j - 1 >= 0){
            if(board[i + 1][j - 1] == 'M'){
                numOfM++;
            }
        }
        // 左
        if(j - 1 >= 0){
            if(board[i][j - 1] == 'M'){
                numOfM++;
            }
        }
        if(numOfM > 0){
            board[i][j] = (char) (numOfM+'0');
        } else {
            // 左上
            if(i - 1 >= 0 && j >= 1){
                if(!visited[i - 1][j - 1]){
                    board[i - 1][j - 1] = 'B';
                    updateLocation(i-1,j-1,board,visited);
                }
            }
            // 上
            if(i - 1 >= 0){
                if(!visited[i - 1][j]){
                    board[i - 1][j] = 'B';
                    updateLocation(i-1,j,board,visited);
                }
            }
            // 右上
            if(i - 1 >= 0 && j + 1 < board[0].length){
                if(!visited[i - 1][j + 1]){
                    board[i - 1][j + 1] = 'B';
                    updateLocation(i - 1,j + 1, board, visited);
                }
            }
            // 右
            if(j + 1 < board[0].length){
                if(!visited[i][j + 1]){
                    board[i][j + 1] = 'B';
                    updateLocation(i, j + 1, board, visited);
                }
            }
            // 右下
            if(i + 1 < board.length && j + 1 < board[0].length){
                if(!visited[i + 1][j + 1]){
                    board[i + 1][j + 1] = 'B';
                    updateLocation(i + 1, j + 1, board, visited);
                }
            }
            // 下
            if(i + 1 < board.length){
                if(!visited[i + 1][j]){
                    board[i + 1][j] = 'B';
                    updateLocation(i + 1, j, board, visited);
                }
            }
            // 左下
            if(i + 1 < board.length && j - 1 >= 0){
                if(!visited[i + 1][j - 1]){
                    board[i + 1][j - 1] = 'B';
                    updateLocation(i + 1, j - 1, board, visited);
                }
            }
            // 左
            if(j - 1 >= 0){
                if(!visited[i][j - 1]){
                    board[i][j - 1] = 'B';
                    updateLocation(i, j - 1, board, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'M', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'}};
        char[][] result = updateBoard(board, new int[]{3,0});

    }
}
