package leetcode.Five.distributeCandies;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/1 5:45 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/1      liuzhaolu       firstVersion
 */
public class Solution {
    public int distributeCandies(int[] candyType) {
        int total = candyType.length;
        Set<Integer> candy = new HashSet<>();
        Arrays.stream(candyType).forEach(candy::add);
        int kinds = candy.size();
        return Math.min(total / 2, kinds);
    }
}
