package leetcode.Four.findMinArrowShots;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-23 14:24
 * @desc 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 *  
 * 示例 1：
 *
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 *
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 *
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 *
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 *
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 *
 *
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class findMinArrowShots {
    /**
     * 寻求坐标点的交集
     * 注意：子集不可交的情况
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        if(points.length <= 1){
            return points.length;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]){
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        // 可以射击的范围
        List<int[]> shootLocation = new ArrayList<>();
        for(int i = 0; i < points.length;i++){
            mergeShootLocation(shootLocation,points[i]);
        }
        return shootLocation.size();
    }

    public static void mergeShootLocation(List<int[]> shootLocation,int[] location){
        // 未射击点
        if(shootLocation.size() == 0){
            shootLocation.add(location);
            return;
        }
        boolean isMerged = false;
        // 射击过，本次射击是否可以合并
        // [1,6][2,8]  -> [2,6]
        // [2,6][7,12]
        for(int i = 0; i <shootLocation.size();i++){
            int[] shootArea = shootLocation.get(i);
            // 射击区域有交集
            if(location[0] >= shootArea[0] && location[0] <= shootArea[1]){
                shootArea[0] = Math.max(location[0],shootArea[0]);
                shootArea[1] = Math.min(location[1],shootArea[1]);
                isMerged = true;
                break;
            }
        }
        if(!isMerged){
            shootLocation.add(location);
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(test));
        int[][] test2 = new int[][]{{1,2},{3,4},{5,6},{7,8}};
        System.out.println(findMinArrowShots(test2));
        int[][] test3 = new int[][]{{1,2},{2,3},{3,4},{4,5}};
        System.out.println(findMinArrowShots(test3));
    }
}
