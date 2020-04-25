package leetcode.ArrayMerge;

import UtilClass.ShowArray;

import java.util.ArrayList;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-16 10:15
 * @desc:给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

 */
public class ArrayMerge extends ShowArray {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] test1 = new int[][]{{1,4},{4,5}};
        int[][] test2 = new int[][]{{1,4},{0,0}};
        ShowArray(merge(test));
        ShowArray(merge(test1));
        ShowArray(merge(test2));
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
//        int[][] result = new int[intervals.length][2];

        sort(intervals);
        List<int[]> result = new ArrayList<>();
        int[] temp = new int[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        for(int i = 1; i < intervals.length;i++){
            // 初始左右
            int left = temp[0];
            int right = temp[1];
            // 右比左大表示可以合并
            if(right >= intervals[i][0]){
                left = Math.min(left,intervals[i][0]);
                right = Math.max(right,intervals[i][1]);
                temp[0] = left;
                temp[1] = right;
            } else {
                result.add(temp);
                temp = new int[2];
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
            }
        }
        result.add(temp);
//        if(result.size() == intervals.length){
//            return list2Array(result);
//        }
//        merge(list2Array(result));
        return list2Array(result);
    }

    private static int[][] list2Array(List<int[]> list){
        int[][] result = new int[list.size()][2];
        for(int i = 0 ; i < list.size(); i ++){
            result[i] = list.get(i);
        }
        return result;
    }

    private static void sort(int[][] intervals){
        for(int i = 0; i < intervals.length; i++){
            for(int j = i; j < intervals.length; j ++){
                if(intervals[j][0] < intervals[i][0]){
                    int[] temp = intervals[j];
                    intervals[j] = intervals[i];
                    intervals[i] = temp;
                }
            }
        }
    }

}
