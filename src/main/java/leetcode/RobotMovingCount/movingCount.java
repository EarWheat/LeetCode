package leetcode.RobotMovingCount;

import java.util.ArrayList;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-08 17:25
 * @desc:地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 */
public class movingCount {
    boolean[][] visited;

    public static void main(String[] args) {
//        System.out.println(movingCount(2,3,1));   // 3
//        System.out.println(movingCount(3,1,0));   // 1
//        System.out.println(movingCount(1,2,1));   // 2
//        System.out.println(movingCount(16,8,4));   // 15
//        System.out.println(movingCount(11,8,16)); // 88
        System.out.println(movingCount(38,15,9));
//        System.out.println(canMove(10,7,16));
    }

    public static int movingCount(int m, int n, int k) {
//        if(canMove(m,n,k)){
//            return m * n;
//        }
        int count = 0;
        int isContinue = 0; // 是否能向右走
        for(int i = 0; i < m; i++){
            if(isContinue > 1){
                break;
            }
            for(int j = 0; j < n; j++){
                if(canMove(i,j,k)){
                    isContinue = 0;
                    count++;
                } else {
                    isContinue++;
                    break;
                }
            }
        }
        return count;
    }

    private static boolean canMove(int m, int n, int k){
        List<Integer> maxM = new ArrayList<>();
        List<Integer> maxN = new ArrayList<>();
        while (m >= 10){
            maxM.add(m % 10);
            m = m /10;
        }
        maxM.add(m);
        while (n >= 10){
            maxN.add(n % 10);
            n = n /10;
        }
        maxN.add(n);
        int total = 0;
        for(int i:maxM){
            total += i;
        }
        for (int j: maxN){
            total += j;
        }
        return total <= k;
    }

    // 标准答案DFS
    private int dfs(int x, int y, int m, int n, int k) {
        if (x >= m || y >= n || visited[x][y]
                || (x % 10 + x / 10 + y % 10 + y / 10) > k) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y, m, n, k) + dfs(x, y + 1, m, n, k);
    }
}
