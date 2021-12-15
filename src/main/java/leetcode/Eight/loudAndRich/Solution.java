package leetcode.Eight.loudAndRich;

import java.util.*;

/**
 * @author ：liuzhaolu
 * @description：851. 喧闹和富有
 * @prd : https://leetcode-cn.com/problems/loud-and-rich/
 * @date ：2021/12/15 3:19 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/15 3:19 下午     liuzhaolu       firstVersion
 */
public class Solution {
    /**
     * 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
     * 输出：[5,5,2,5,4,5,6,7]
     * 解释：
     * answer[0] = 5，
     * person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
     * 唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
     * 但是目前还不清楚他是否比 person 0 更有钱。
     * answer[7] = 7，
     * 在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
     * 最安静（有较低安静值 quiet[x]）的人是 person 7。
     * 其他的答案也可以用类似的推理来解释。
     * @param richer
     * @param quiet
     * @return
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        if(richer.length == 0){
            int[] answer = new int[quiet.length];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = i;
            }
            return answer;
        }
        Map<Integer, List<Integer>> richerThanMe = new HashMap<>();
        for (int i = 0; i < richer.length; i++) {
            List<Integer> richers;
            if(richerThanMe.containsKey(richer[i][1])){
                richers = richerThanMe.get(richer[i][1]);
            } else {
                richers = new ArrayList<>();
            }
            richers.add(richer[i][0]);
            richerThanMe.put(richer[i][1], richers);
        }
        int persons = quiet.length;
        int[] answer = new int[persons];
        for (int i = 0; i < persons; i++) {
            Set<Integer> richers = getRichers(i, richerThanMe);
            answer[i] = i;
            int quietestVal = quiet[i];
            for (Integer rich : richers) {
                if(quiet[rich] < quietestVal){
                    quietestVal = quiet[rich];
                    answer[i] = rich;
                }
            }
        }
        return answer;
    }

    private Set<Integer> getRichers(int i, Map<Integer, List<Integer>> richerThanMe){
        Set<Integer> result = new HashSet<>();
        if (richerThanMe.containsKey(i)){
            List<Integer> temp = richerThanMe.get(i);
            result.addAll(temp);
            for(Integer j : temp){
                result.addAll(getRichers(j, richerThanMe));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
        int[][] richer = new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = new int[]{3,2,5,4,6,1,7,0};
        Solution solution = new Solution();
        System.out.println(solution.loudAndRich(richer,quiet));
    }

}
