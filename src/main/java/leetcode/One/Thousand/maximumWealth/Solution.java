package leetcode.One.Thousand.maximumWealth;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：1672. 最富有客户的资产总量
 * @prd : https://leetcode-cn.com/problems/richest-customer-wealth/
 * @date ：2022/4/14 3:02 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/14 3:02 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] user : accounts) {
            max = Math.max(max, Arrays.stream(user).sum());
        }
        return max;
    }
}
