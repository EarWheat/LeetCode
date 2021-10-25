package leetcode.One.Thousand.isCovered;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/23 3:25 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]){
                    return -1;
                } else if(o1[0] > o2[0]){
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int[] temp : ranges) {
            if (left >= temp[0] && right <= temp[1]) {
                return true;
            }
            if (left >= temp[0] && left <= temp[1]){
                left = temp[1] + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ranges = new int[][]{{1,2},{3,4},{5,6}};
        System.out.println(solution.isCovered(ranges,2,5));
    }
}
