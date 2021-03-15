package leetcode.Five.spiralOrder;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/15 上午7:14
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        result.add(matrix[0][0]);
        visited[0][0] = true;

        while (canVisited(i,j,visited)){
            boolean continueR = true;
            boolean continueD = true;
            boolean continueL = true;
            boolean continueU = true;
            while (continueR) {
                continueR = dfs(i, j, "right", visited, matrix, result);
                if (continueR) {
                    j++;
                }
            }
            while (continueD){
                continueD = dfs(i,j,"down",visited,matrix,result);
                if (continueD) {
                    i++;
                }
            }
            while (continueL){
                continueL = dfs(i,j,"left",visited,matrix,result);
                if(continueL){
                    j--;
                }
            }
            while (continueU){
                continueU = dfs(i,j,"up",visited,matrix,result);
                if(continueU){
                    i--;
                }
            }
        }
        return result;
    }

    public static boolean canVisited(int i, int j, boolean[][] visited){
        boolean canVisited = false;
        if(i - 1 >= 0){
            canVisited = canVisited || !visited[i - 1][j];
        }
        if(i + 1 < visited.length){
            canVisited = canVisited || !visited[i + 1][j];
        }
        if(j + 1 < visited[0].length){
            canVisited = canVisited || !visited[i][j + 1];
        }
        if(j - 1 >= 0){
            canVisited = canVisited || !visited[i][j - 1];
        }
        return canVisited;
    }

    public static boolean dfs(int i, int j, String style, boolean[][] visited, int[][] matrix, List<Integer> result){
        if(style.equals("right")){
            if(j + 1 < matrix[0].length && !visited[i][j + 1]){
                j++;
                result.add(matrix[i][j]);
                visited[i][j] = true;
                return true;
            }
        }
        if(style.equals("down")){
            if(i + 1 < matrix.length && !visited[i + 1][j]){
                i++;
                result.add(matrix[i][j]);
                visited[i][j] = true;
                return true;
            }
        }
        if(style.equals("left")){
            if(j - 1 >= 0 && !visited[i][j - 1]){
                j--;
                result.add(matrix[i][j]);
                visited[i][j] = true;
                return true;
            }
        }
        if(style.equals("up")){
            if(i - 1 >= 0 && !visited[i - 1][j]){
                i--;
                result.add(matrix[i][j]);
                visited[i][j] = true;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(spiralOrder(matrix));
    }
}
