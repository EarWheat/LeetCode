package leetcode.zero.solveSudoku;


import java.io.*;
import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-15 15:40
 * @desc
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * 一个数独。
 *
 * 答案被标成红色。
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class solveSudoku {
    private LinkedList<Set<Character>> lineUsedNum = new LinkedList<>();    // 行已经使用的数值
    private LinkedList<Set<Character>> cellUsedNum = new LinkedList<>();    // 列已经使用的数值
    private LinkedList<Set<Character>> squareUsedNum = new LinkedList<>();    // 3 * 3方格已经使用的数字
    /**
     * 思路：
     * 试错，试每一个位置的可能值
     * @param board
     */
    public void solveSudoku(char[][] board) {
//        LinkedList<Set<Character>> lineUsedNum = new LinkedList<>();    // 行已经使用的数值
//        LinkedList<Set<Character>> cellUsedNum = new LinkedList<>();    // 列已经使用的数值
//        LinkedList<Set<Character>> squareUsedNum = new LinkedList<>();    // 3 * 3方格已经使用的数字
        // 初始化
        for(int i = 0; i < 9; i++){
            Set<Character> characters = new HashSet<>();
            squareUsedNum.add(characters);
            Set<Character> lineSetNum = new HashSet<>();    // 本行已使用的数字集合
            lineUsedNum.add(lineSetNum);
            Set<Character> cellSetNum = new HashSet<>(); // 本列已使用的数字集合
            cellUsedNum.add(cellSetNum);
        }
        // 初始化记录
        formatUsedNum(board);
        fillBoard(0,0,board,lineUsedNum,cellUsedNum,squareUsedNum);
    }

    // 先遍历一遍棋盘，存储已经填了的数字
    private void formatUsedNum(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    cellUsedNum.get(j).add(board[i][j]);
                    lineUsedNum.get(i).add(board[i][j]);
                    fillSquareUsedNum(i,j,board[i][j]);
                }
            }
        }
    }

    // 将3 * 3的小格子按坐标i,j归类
    private void fillSquareUsedNum(int i, int j, char board){
        squareUsedNum.get(getSquareLocation(i,j)).add(board);
    }

    // 找可以使用的数字
    private Set<Character> canUsed(int i, int j, LinkedList<Set<Character>> lineUsedNum, LinkedList<Set<Character>> cellUsedNum, LinkedList<Set<Character>> squareUsedNum){
        Set<Character> set = new HashSet<>();
        for(int n = 1; n <= 9; n++){
            if(!lineUsedNum.get(i).contains(Character.forDigit(n,10)) && !cellUsedNum.get(j).contains(Character.forDigit(n,10)) && !squareUsedNum.get(getSquareLocation(i,j)).contains(Character.forDigit(n,10))){
                set.add(Character.forDigit(n,10));
            }
        }
        return set;
    }

    private int getSquareLocation(int i, int j){
        return (3 * (i / 3)) + (j / 3);
    }

    // 填充空白
    private boolean fillBoard(int i, int j, char[][] board, LinkedList<Set<Character>> lineUsedNum, LinkedList<Set<Character>> cellUsedNum, LinkedList<Set<Character>> squareUsedNum) {

        while (board[i][j] != '.'){
            // 最后一列换行
            if(++j >= 9){
                i++;
                j = 0;
            }
            // 遍历完毕
            if (i >= 9) {
                return true;
            }
        }
        // 找可用的值
        Set<Character> canUsed = canUsed(i,j,lineUsedNum,cellUsedNum,squareUsedNum);
        if(canUsed.size() == 0){
            return false;
        }
        for(Character character : canUsed){
            // 尝试每一个可用的值
            board[i][j] = character;
            lineUsedNum.get(i).add(character);
            cellUsedNum.get(j).add(character);
            squareUsedNum.get(getSquareLocation(i,j)).add(character);
            if(fillBoard(i,j,board,lineUsedNum,cellUsedNum,squareUsedNum)){
                return true;
            } else {
                // 还原场景
                board[i][j] = '.';
                lineUsedNum.get(i).remove(character);
                cellUsedNum.get(j).remove(character);
                squareUsedNum.get(getSquareLocation(i,j)).remove(character);
            }
        }
        return false;
    }

    public static void main(String[] args)  {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku solveSudoku = new solveSudoku();
        solveSudoku.solveSudoku(board);
        System.out.println(board.toString());
    }
}
