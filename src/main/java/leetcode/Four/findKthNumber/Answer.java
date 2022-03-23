package leetcode.Four.findKthNumber;

/**
 * @author ：liuzhaolu
 * @description：答案
 * @prd :
 * @date ：2022/3/23 2:36 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/23 2:36 下午     liuzhaolu       firstVersion
 */
public class Answer {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(curr, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    public int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}
