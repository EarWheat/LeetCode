package leetcode.Zero.insert;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-04 15:32
 * @desc 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class insert {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{{newInterval[0],newInterval[1]}};
        }
        int left = newInterval[0];  // 左边界
        int right = newInterval[1]; // 右边界
        List<List<Integer>> list = new ArrayList<>();
        // 待插入的区间比最大值还大
        if(left >= intervals[intervals.length - 1][1]){
            return insertLast(intervals,newInterval);
        }
        if(right <= intervals[0][0]){
            return insertBegin(intervals,newInterval);
        }
        int index = 0;
        while (index < intervals.length){
            List<Integer> temp = new ArrayList<>();
            if(intervals[index][0] > left && intervals[index][0] < right){
                temp.add(left);
            } else {
                temp.add(intervals[index][0]); // 先插入左边界
            }
            if(intervals[index][1] >= left && intervals[index][1] < right){ // 原区间右边界在待插入的区间里
                index++;
                if(index >= intervals.length){
                    temp.add(right);
                    list.add(temp);
                    break;
                }
                if(intervals[index][0] > right){
                    temp.add(right);
                    list.add(temp);
                    continue;
                } else {
                    while (intervals[index][1] < right){
                        index++;
                        if(index >= intervals.length){
                            break;
                        }
                    }
                    if(index < intervals.length){
                        if(intervals[index][0] > right){
                            temp.add(right);
                            list.add(temp);
                            temp = new ArrayList<>();
                            temp.add(intervals[index][0]);
                        }
                    }
                }
            }
            else if(index < intervals.length - 1 && intervals[index][1] < left && intervals[index + 1][0] > right){ // 在原区间中间刚好有位置可以插入新区间
                temp.add(intervals[index][1]); // 插入右边界
                list.add(temp);
                index++;
                temp = new ArrayList<>();
                temp.add(left);
                temp.add(right);
                list.add(temp);
                continue;
            }
            if(index >= intervals.length){
                temp.add(right);
            } else {
                temp.add(intervals[index][1]); // 插入右边界
            }
            list.add(temp);
            index++;
        }
        return list2Int(list);
    }

    public static int[][] list2Int(List<List<Integer>> list){
        int[][] result = new int[list.size()][2];
        int i = 0;
        for(List<Integer> temp : list){
            result[i][0] = temp.get(0);
            result[i][1] = temp.get(1);
            i++;
        }
        return result;
    }

    public static int[][] insertLast(int[][] intervals, int[] newInterval){
        int[][] result;
        if(newInterval[0] == intervals[intervals.length - 1][1]){
            result = new int[intervals.length][2];
        } else {
            result = new int[intervals.length + 1][2];
        }
        for(int i = 0; i < intervals.length;i++){
            result[i] = intervals[i];
        }
        if(intervals.length == result.length){
            result[result.length - 1][1] = newInterval[1];
        } else {
            result[intervals.length] = newInterval;
        }
        return result;
    }

    public static int[][] insertBegin(int[][] intervals, int[] newInterval){
        int[][] result;
        if(newInterval[1] == intervals[0][0]){
            result = new int[intervals.length][2];
            result[0][0] = newInterval[0];
            result[0][1] = intervals[0][1];
            for(int i = 1; i < intervals.length;i++){
                result[i] = intervals[i];
            }
        } else {
            result = new int[intervals.length + 1][2];
            for(int i = 0; i < intervals.length;i++){
                result[i + 1] = intervals[i];
            }
            result[0] = newInterval;
        }
        return result;
    }

    // * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    public static void main(String[] args) {
        int[][] result12 = insert(new int[][]{{0,0},{2,4},{9,9}},new int[]{0,7});
        System.out.println(JSONObject.toJSONString(result12));
        int[][] result2 = insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
        System.out.println(JSONObject.toJSONString(result2));
        int[][] result11 = insert(new int[][]{{1,5},{6,8}},new int[]{0,9});
        System.out.println(JSONObject.toJSONString(result11));
        int[][] result10 = insert(new int[][]{{1,5}},new int[]{0,3});
        System.out.println(JSONObject.toJSONString(result10));
        int[][] result9 = insert(new int[][]{{1,5}},new int[]{2,9});
        System.out.println(JSONObject.toJSONString(result9));
        int[][] result8 = insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
        System.out.println(JSONObject.toJSONString(result8));
        int[][] result7 = insert(new int[][]{{4,5},{6,9}},new int[]{1,4});
        System.out.println(JSONObject.toJSONString(result7));
        int[][] result6 = insert(new int[][]{{4,5},{6,9}},new int[]{9,12});
        System.out.println(JSONObject.toJSONString(result6));
        int[][] result5 = insert(new int[][]{{4,5},{6,9}},new int[]{1,2});
        System.out.println(JSONObject.toJSONString(result5));
        int[][] result4 = insert(new int[][]{{1,3},{6,9}},new int[]{12,16});
        System.out.println(JSONObject.toJSONString(result4));
        int[][] result3 = insert(new int[][]{{1,3},{6,9}},new int[]{4,5});
        System.out.println(JSONObject.toJSONString(result3));
        int[][] result = insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{2,8});
        System.out.println(JSONObject.toJSONString(result));
    }
}
