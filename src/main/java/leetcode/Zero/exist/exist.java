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
        boolean result = false;
        boolean[][] visited;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    visited = new boolean[board.length][board[0].length];
                    result = result || wordMatch(board,visited,word,i,j);
                }
            }
        }
        return result;
    }

    public static boolean wordMatch(char[][] board, boolean[][] visited, String word, int i, int j){
        if(word.length() == 0){
            return true;
        }
        if(i < 0 || i >= board.length){
            return false;
        }
        if(j < 0 || j >= board[0].length){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        if(board[i][j] == word.charAt(0)){
            visited[i][j] = true;
            return wordMatch(board,visited,word.substring(1),i + 1,j)
                    || wordMatch(board,visited,word.substring(1),i - 1,j)
                    || wordMatch(board,visited,word.substring(1),i,j + 1)
                    || wordMatch(board,visited,word.substring(1),i,j - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] test = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] test2 = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        System.out.println(exist(test2,"AAB"));
        System.out.println(exist(test,"ABCCED"));
        System.out.println(exist(test,"SEE"));
        System.out.println(exist(test,"ABCB"));
        System.out.println(exist(test,"SECC"));
    }
}
