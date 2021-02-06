package leetcode.One.Thousand.maxScore;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/6 下午7:43
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length, sum = 0;
        for (int cardPoint: cardPoints) {
            sum += cardPoint;
        }
        int min = Integer.MAX_VALUE, temp = 0;
        int length = len - k;
        for (int i = 0; i < len; i++) {
            temp += cardPoints[i];
            if (i >= length) {
                temp -= cardPoints[i - length];
            }
            if (i >= length - 1)
                min = Math.min(min, temp);
        }
        return sum - min;
    }
}
