package leetcode.Zero.exist;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-13 08:31
 * @desc 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class exist {
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                boolean flag = wordMatch(board,visited,word,i,j,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordMatch(char[][] board, boolean[][] visited, String word, int i, int j, int k){
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = wordMatch(board, visited, word, newi, newj, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] test = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] test2 = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        System.out.println(exist(test2,"AAB"));
        System.out.println(exist(test,"ABCESEEEFS"));
        System.out.println(exist(test,"SEE"));
        System.out.println(exist(test,"ABCB"));
        System.out.println(exist(test,"SECC"));
    }
}
