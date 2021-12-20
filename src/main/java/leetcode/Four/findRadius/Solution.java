package leetcode.Four.findRadius;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/12/20 2:43 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/20 2:43 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters){
        int maxGap = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        for (int i = 0; i < houses.length; i++) {
            int houseLocation = houses[i];
            while (j < heaters.length - 1
                && (Math.abs(houseLocation - heaters[j]) >= Math.abs(houseLocation - heaters[j + 1]))){
                j = j + 1;
            }
            maxGap = Math.max(Math.abs(houseLocation - heaters[j]), maxGap);
        }
        return maxGap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRadius(new int[]{1,1,1,1,1,999,999,999,999,999}, new int[]{499,500,501}));
    }
}
