package leetcode.Eight.numFriendRequests;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：825. 适龄的朋友
 * @prd : https://leetcode-cn.com/problems/friends-of-appropriate-ages/
 * @date ：2021/12/27 2:33 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/27 2:33 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                ++left;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                ++right;
            }
            ans += right - left;
        }
        return ans;
    }

    /**
     * age[y] <= 0.5 * age[x] + 7
     * age[y] > age[x]
     * age[y] > 100 && age[x] < 100
     *
     * @param age1
     * @param age2
     * @return
     */
    public boolean sendRequest(int age1, int age2) {
        if ((age2 <= 0.5 * age1 + 7)
                || (age2 > age1)
                || (age2 > 100 && age1 < 100)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sendRequest(1,101));
    }
}
