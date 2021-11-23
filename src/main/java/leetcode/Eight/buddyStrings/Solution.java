package leetcode.Eight.buddyStrings;

import org.checkerframework.checker.units.qual.C;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/23 5:21 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/23      liuzhaolu       firstVersion
 */
public class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < goal.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && s.charAt(first) == goal.charAt(second) &&
                    s.charAt(second) == goal.charAt(first));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buddyStrings("abcaa","abcbb"));
    }
}
