package leetcode.Nine.kClosest;

import coding.Pack;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-09 15:13
 * @desc 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *  
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class kClosest {
    /**
     * 用队列来记录，先放进K个点。距离最大的放入队首，距离最小放入队尾。
     * 发现比队尾还近的点就出队列入队列
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        if(points.length < K){
            return points;
        }
        Arrays.sort(points,(int[] o1,int[] o2) -> squareSum(o1) > squareSum(o2) ? 1 : -1);
        return Arrays.copyOfRange(points,0,K);
    }

    public static int squareSum(int[] a){
        return (a[0] * a[0]) + (a[1] * a[1]);
    }

    public int[][] list2Array(List<int[]> list){
        int[][] result = new int[list.size()][2];
        for(int i= 0;i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{3,3},{5,-1},{-2,4},{1,-1},{3,-3}};
        Arrays.sort(points,(int[] o1,int[] o2) -> {
            return squareSum(o1) > squareSum(o2) ? 1 : -1;
        });
        System.out.println(JSONObject.toJSONString(points));
    }
}
