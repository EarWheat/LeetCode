package leetcode.EightQueen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-09-03 11:08
 * @desc:n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
输入：4
输出：[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

 */
public class solveNQueens {
    private int n;
    // 记录某一列是否放置了皇后
    private boolean[] col;
    // 记录主对角线上的单元格是否放置了皇后
    private boolean[] main;
    // 记录了副对角线上的单元格是否放置了皇后
    private boolean[] sub;
    private List<List<String>> result;

    /**
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0){
            return result;
        }
        this.n = n;
        this.col = new boolean[n];
        this.main = new boolean[2 * n - 1];
        this.sub = new boolean[2 * n - 1];
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(0, deque);
        return result;
    }

    private void dfs(int row, Deque<Integer> deque){
        // 最后一行
        if(row == n){
            // 深度优先遍历到下标为 n，表示 [0.. n - 1] 已经填完，得到了一个结果
            List<String> board = convert2board(deque);
            result.add(board);
            return;
        }
        // 针对下标为 row 的每一列，尝试是否可以放置
        for (int j = 0; j < n; j++) {
            if (!col[j] && !main[row + j] && !sub[row - j + n - 1]) {
                deque.addLast(j);
                col[j] = true;
                main[row + j] = true;
                sub[row - j + n - 1] = true;

                dfs(row + 1, deque);
                // 递归完成以后，回到之前的结点，需要将递归之前所做的操作恢复

                sub[row - j + n - 1] = false;
                main[row + j] = false;
                col[j] = false;
                deque.removeLast();
            }
        }

    }

    private List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            row.append(".".repeat(Math.max(0, n)));
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }


}
