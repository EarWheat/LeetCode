package leetcode.Two.Thousand.goodDaysToRobBank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：2100. 适合打劫银行的日子
 * @prd : https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/
 * @date ：2022/3/6 2:39 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/6 2:39 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int n = security.length;
        int[] pre = new int[n + 1];
        pre[0] = 0;
        pre[1] = 0;//递减的
        for (int i = 2; i <= n; i++) {
            if (security[i - 1] <= security[i - 2]) {
                pre[i] = pre[i - 1] + 1;
            }
        }
        int[] aft = new int[n + 1];//递减的
        aft[n] = 0;
        aft[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) aft[i] = aft[i + 1] + 1;

        }
        //为了让右边有time个，所以 i<n-time
        for (int i = time; i < n - time; i++) {
            //i-> i-1             i->i
            if (pre[i + 1] >= time && aft[i] >= time) res.add(i);
        }
        return res;
    }
}
