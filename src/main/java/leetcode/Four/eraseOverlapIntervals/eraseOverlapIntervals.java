package leetcode.Four.eraseOverlapIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020/12/31 下午4:33
 * @desc 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class eraseOverlapIntervals {
    /**
     * [1,10],[4,11],[5,6],[7,9],[10,11]
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2 [0]){
                    return 1;
                } else if(o1[0] == o2[0]){
                    return 0;
                }
                return -1;
            }
        });
        int i = 0;
        int result = 0;
        while (i < intervals.length - 1){
            int[] temp1 = intervals[i];
            int[] temp2 = intervals[i + 1];
            if(temp1[1] > temp2[0]){
                result++;
                // 干掉长区间
                int length1 = temp1[1] - temp1[0];
                int length2 = temp2[1] - temp1[0];
                if(length1 > length2){
                    intervals = removeInt(intervals,i);
                } else {
                    intervals = removeInt(intervals,i + 1);
                }
            } else {
                i++;
            }
        }
        return result;
    }

    public static int[][] removeInt(int[][] intervals, int index){
        int[][] newIntervals = new int[intervals.length - 1][2];
        for(int i = 0; i < index; i++){
            newIntervals[i] = intervals[i];
        }
        for(int i = index + 1; i < intervals.length; i++){
            newIntervals[i - 1] = intervals[i];
        }
        return newIntervals;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
