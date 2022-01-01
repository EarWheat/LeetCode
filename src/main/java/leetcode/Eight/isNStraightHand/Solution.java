package leetcode.Eight.isNStraightHand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liuzhaolu
 * @description：846. 一手顺子
 * @prd : https://leetcode-cn.com/problems/hand-of-straights/
 * @date ：2021/12/30 6:30 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/30 6:30 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : hand) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        for (int x : hand) {
            if (!cnt.containsKey(x)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int num = x + j;
                if (!cnt.containsKey(num)) {
                    return false;
                }
                cnt.put(num, cnt.get(num) - 1);
                if (cnt.get(num) == 0) {
                    cnt.remove(num);
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }
}
