package leetcode.One.Thousand.maxSatisfied;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/23 上午11:16
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if(X >= customers.length){
            return Arrays.stream(customers).sum();
        }
        // 滑动窗口使得收益最大化
        int satisfied = 0;
        int maxProfits = 0;     // 最大收益
        int skillUsedIndex = 0; // 技能使用的索引位置
        int index = 0;  // 窗口位置
        while (index <= customers.length - X){
            int profits = calculateProfits(customers,grumpy,index,index + X - 1);
            if(profits > maxProfits){
                maxProfits = profits;
                skillUsedIndex = index;
            }
            index++;
        }
        // 计算最大收益
        // 将grumpy置为0
        for (int i = skillUsedIndex; i < skillUsedIndex + X; i++) {
            grumpy[i] = 0;
        }
        for (int i = 0; i < customers.length; i++) {
            if(grumpy[i] == 0){
                satisfied += customers[i];
            }
        }
        return satisfied;
    }

    public int calculateProfits(int[] customers, int[] grumpy, int i, int j){
        int profits = 0;    // 收益, 收益为grumpy = 1的部分
        for (int k = i; k <= j; k++) {
            if(grumpy[k] == 1){
                profits += customers[k];
            }
        }
        return profits;
    }

    public static void main(String[] args) {
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        Solution solution = new Solution();
        System.out.println(solution.maxSatisfied(customers,grumpy,3));
    }
}
