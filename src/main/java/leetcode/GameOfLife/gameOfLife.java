package leetcode.GameOfLife;

import UtilClass.ShowArray;

import java.util.HashMap;
import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-02 14:07
 * @desc:根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。

输入：
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
输出：
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
*
* 思路: 题目要求不开辟额外的空间，使用in-place方法。因为要所有点统一刷新，但是for循环是一个一个的遍历，所以要即更新点，又要保存原来的状态。
* 有一个int表示双含义的话，可以使用高位和低位来表示。
* 因为只有死或两个状态，所以用0，1表示即可。
* 10:新状态为1，旧状态为0
* 11:新状态为活，旧状态为死
 */
public class gameOfLife extends ShowArray {
    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int length = board.length;
        int weight = board[0].length;
        System.out.println("length:"+length);
        System.out.println("weight:"+weight);
        ShowArray(board);
    }

    public void gameOfLife(int[][] board) {
        int [][] lifes = new int[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                find(board,i,j,lifes);
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                board[i][j] = lifes[i][j];
            }
        }
    }

    public void find(int [][] board,int i,int j,int [][]lifes){
        int life = 0;
        //下方
        if(i<board.length-1&&board[i+1][j] == 1) life ++;
        //上方
        if(i>0 && board[i-1][j] == 1) life ++;
        //右下方
        if(i<board.length-1&&j<board[i].length-1&&board[i+1][j+1]==1) life++;
        //左下方
        if(i<board.length-1&&j>0&&board[i+1][j-1]==1)life++;
        //右上方
        if(i>0&&j<board[i].length-1&&board[i-1][j+1]==1) life++;
        //左上方
        if(i>0&&j>0&&board[i-1][j-1]==1) life ++;
        //右方
        if(j<board[i].length-1&&board[i][j+1]==1) life++;
        //左方
        if(j>0&& board[i][j-1]==1) life++;

        if(life<2) lifes[i][j]=0;
        else if(life==2) lifes[i][j]=board[i][j];
        else if(life==3) lifes[i][j] = 1;
        else if(life>3) lifes[i][j] = 0;

    }

}
