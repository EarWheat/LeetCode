package leetcode.Two.hIndex;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/11 下午11:22
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
