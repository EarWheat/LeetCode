package leetcode.Five.findMaximizedCapital;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 2:41 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    /**
     * 输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
     * 输出：4
     * 解释：
     * 由于你的初始资本为 0，你仅可以从 0 号项目开始。 在完成后，你将获得 1 的利润，你的总资本将变为 1。
     * 此时你可以选择开始 1 号或 2 号项目。 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
     * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        boolean[] chooseEvent = new boolean[capital.length];
        int index = Integer.MIN_VALUE;
        int maxProfits = Integer.MIN_VALUE;
        for (int j = 0; j < k; j++) {   // 选择K个项目
            index = Integer.MIN_VALUE;
            maxProfits = Integer.MIN_VALUE;
            for (int i = 0; i < capital.length; i++) {
                // 已经选择过该项目
                if(chooseEvent[i]){
                    continue;
                }
                if(capital[i] <= w){
                    if(profits[i] > maxProfits){
                        // 该项目备选
                        index = i;
                        maxProfits = profits[i];
                    }
                }
            }
            if(index != Integer.MIN_VALUE && maxProfits != Integer.MIN_VALUE){
                chooseEvent[index] = true;
                w += maxProfits;
            }
        }
        return w;
    }
}
