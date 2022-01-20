package leetcode.Two.stoneGameIX;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：2029. 石子游戏 IX
 * @prd : https://leetcode-cn.com/problems/stone-game-ix/
 * @date ：2022/1/20 2:14 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/20 2:14 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] temp = new int[3];
        for (int i = 0; i < stones.length; i++) {
            temp[stones[i] % 3]++;
        }
        int m = Math.abs(temp[1] - temp[2]);
        if(temp[0] % 2 == 0){
            if(temp[1] != 0 && temp[2] != 0){
                return true;
            }
        } else {
            if(m >= 3){
                return true;
            }
        }
        return false;
    }
}
