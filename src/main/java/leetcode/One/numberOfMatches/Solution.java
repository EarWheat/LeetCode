package leetcode.One.numberOfMatches;

/**
 * @author ：liuzhaolu
 * @description：1688. 比赛中的配对次数
 * @prd : https://leetcode-cn.com/problems/count-of-matches-in-tournament/
 * @date ：2022/1/25 10:28 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/25 10:28 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public int numberOfMatches(int n) {
        int result = 0;
        while (n > 1){
            result += n % 2 == 0 ? n / 2 : (n - 1) / 2;
            n = n % 2 == 0 ?  n / 2 : (n - 1) / 2 + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfMatches(7));
    }
}
