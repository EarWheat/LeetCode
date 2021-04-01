package leetcode.One.Thousand.clumsy;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/1 下午6:12
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    String[] yunsuan = new String[]{"*","/","+","-"};
    public boolean plus = true;
    // 11 + 7 - 7 + 3 - 2
    public int clumsy(int N) {
        Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
        boolean isCalculate = true;
        while (N > 0){
            if(isCalculate){
                queue.add(calculate(N));
                N = N - 3;
            } else {
                queue.add(N);
                N--;
            }
            isCalculate = !isCalculate;
        }
        boolean isPlus = true;
        if(queue.isEmpty()){
            return 0;
        }
        int result = queue.poll();
        while (!queue.isEmpty()){
            int temp = queue.poll();
            if(isPlus){
                result += temp;
            } else {
                result -= temp;
            }
            isPlus = !isPlus;
        }
        return result;
    }

    public int calculate(int N){
        if(N == 2){
            return 2;
        }
        if(N == 1){
            return 1;
        }
        return N * (N - 1) / (N - 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.clumsy(4));
    }
}
