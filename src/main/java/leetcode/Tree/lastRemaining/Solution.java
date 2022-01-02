package leetcode.Tree.lastRemaining;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：390. 消除游戏
 * @prd : https://leetcode-cn.com/problems/elimination-game/
 * @date ：2022/1/2 9:50 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/2 9:50 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public int lastRemaining(int n) {
        int ans = 1;
        int forwords = 1;
        for(int i = 0; n > 1 ;i++){
            if(i % 2 == 0 || n % 2 == 1){
                ans += forwords;
            }
            n /= 2;
            forwords *= 2;
        }
        return ans;
    }
}
