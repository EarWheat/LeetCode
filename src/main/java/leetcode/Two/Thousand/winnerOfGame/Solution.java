package leetcode.Two.Thousand.winnerOfGame;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：2038. 如果相邻两个颜色均相同则删除当前颜色
 * @prd : https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 * @date ：2022/3/22 5:30 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/22 5:30 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean winnerOfGame(String colors) {
        int a = nums(colors, 'A');
        if(a == 0){
            return false;
        }
        int b = nums(colors, 'B');
        return a > b;
    }

    public int nums(String colors, char a){
        int slow = 0;
        int fast = 0;
        int res = 0;
        for (slow = 0; slow < colors.length(); slow++) {
            fast = slow;
            if(colors.charAt(slow) == a){
                while (fast < colors.length() && colors.charAt(fast) == a){
                    fast++;
                    if(fast - slow == 3){
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nums("BBBAAAABB",'A'));
    }
}
