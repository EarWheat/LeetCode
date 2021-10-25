package leetcode.Zero.isValidSudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/17 5:14 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] line = new boolean[board.length]; // 行
        boolean[] cell = new boolean[board[0].length];  // 列
        boolean[] square = new boolean[9]; // 方形
        // 检查行
        for (int i = 0; i < board.length; i++) {
            Set<Character> nums = new HashSet<>(9);
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.'){
                    if(nums.contains(board[i][j])){
                        return false;
                    } else {
                        nums.add(board[i][j]);
                    }
                }
            }
        }
        // 检查列
        for (int j = 0; j < board[0].length; j++) {
            Set<Character> nums = new HashSet<>(9);
            for (int i = 0; i < board.length; i++) {
                if(board[i][j] != '.'){
                    if(nums.contains(board[i][j])){
                        return false;
                    } else {
                        nums.add(board[i][j]);
                    }
                }
            }
        }
        // 检查square
        // 前3个square()
        for (int p = 0; p < board.length; p = p + 3) {
            for(int q = 0; q < board.length; q = q+3){
                Set<Character> nums = new HashSet<>(9);
                for (int i = p; i < p + 3; i++) {
                    for (int j = q; j < q + 3; j++) {
                        if(board[i][j] != '.'){
                            if(nums.contains(board[i][j])){
                                return false;
                            } else {
                                nums.add(board[i][j]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
