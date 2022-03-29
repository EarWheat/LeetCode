package leetcode.Two.Thousand.maxConsecutiveAnswers;

import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ：liuzhaolu
 * @description：2024. 考试的最大困扰度
 * @prd : https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/
 * @date ：2022/3/29 2:53 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/29 2:53 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0;
        int right = k;
        int numT = 0;
        int numF = 0;
        int resp = k;
        for (int i = left; i < right; i++) {
            if (answerKey.charAt(i) == 'T') {
                numT++;
            } else {
                numF++;
            }
        }
        while (right < answerKey.length() && left <= right) {
            int num = Math.min(numF, numT);
            if (num < k) {
                if (answerKey.charAt(right) == 'T') {
                    numT++;
                } else {
                    numF++;
                }
                right++;
            } else if(num == k && right + 1 < answerKey.length()){
                char c = answerKey.charAt(right + 1);
                if((c == 'F' && numT < numF) || (c == 'T' && numF < numT)){
                    right++;
                } else {
                    break;
                }
            } else {
                if (answerKey.charAt(left) == 'T') {
                    numT--;
                } else {
                    numF--;
                }
                left++;
            }
            resp = Math.max(resp, right - left + 1);
        }
        return resp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxConsecutiveAnswers("TFFT", 1));
    }
}
