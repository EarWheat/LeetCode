package leetcode.One.Thousand.minCostConnectPoints;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/19 上午10:52
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class minCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        // 按到0，0的曼哈顿距离排序先排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dis1 = Math.abs(o1[0]) + Math.abs(o1[1]);
                int dis2 = Math.abs(o2[0]) + Math.abs(o2[1]);
                if(dis1 > dis2){
                    return 1;
                } else if(dis1 == dis2){
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        // 再分为4个象限去计算
        LinkedList<int[]> quadrant1 = new LinkedList<>();
        LinkedList<int[]> quadrant2 = new LinkedList<>();
        LinkedList<int[]> quadrant3 = new LinkedList<>();
        LinkedList<int[]> quadrant4 = new LinkedList<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            if(x >= 0 && y >= 0){
                quadrant1.add(point);
            } else if(x >= 0 && y <= 0){
                quadrant4.add(point);
            } else if(x <= 0 && y >= 0){
                quadrant2.add(point);
            } else if(x <= 0 && y <= 0){
                quadrant3.add(point);
            }
        }
        // 分别计算4个象限各自内部距离
        int distance1 = computeDistance(quadrant1);
        int distance2 = computeDistance(quadrant2);
        int distance3 = computeDistance(quadrant3);
        int distance4 = computeDistance(quadrant4);
        // 统一距离，4个象限合并
        Map<Integer, int[]> map = new HashMap<>();
        Optional.of(quadrant1).ifPresent(e -> map.put(1,e.get(0)));
        Optional.of(quadrant2).ifPresent(e -> map.put(2,e.get(0)));
        Optional.of(quadrant3).ifPresent(e -> map.put(3,e.get(0)));
        Optional.of(quadrant4).ifPresent(e -> map.put(4,e.get(0)));
        int distance0 = computeDistanceQ(map);
        return distance0 + distance1 + distance2 + distance3 + distance4;
    }

    /**
     * 计算距离
     * @param points
     * @return
     */
    public int computeDistance(LinkedList<int[]> points){
        if(points.size() == 0){
            return 0;
        }
        int result = 0;
        int[] temp = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            int[] point = points.get(i);
            result += computeDistance(point, temp);
            temp = point;
        }
        return result;
    }

    public int computeDistanceQ(Map<Integer, int[]> map){
        int dis12 = computeDistance(map.get(1), map.get(2));    // 1-2象限边
        int dis23 = computeDistance(map.get(2), map.get(3));    // 2-3象限边
        int dis34 = computeDistance(map.get(3), map.get(4));    // 3-4象限边
        int dis14 = computeDistance(map.get(1), map.get(4));    // 1-4象限边
        int[] temp = new int[]{dis12,dis23,dis34,dis14};
        // 选最小的3条边相连
        Arrays.sort(temp);
        return temp[0] + temp[1] + temp[2] + temp[3];
    }

    public int computeDistance(int[] point1, int[] point2){
        if(point1 == null || point2 == null){
            return 0;
        }
        // 少了一个点
        if(point1.length <= 0 || point2.length <= 0){
            return 0;
        }
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    public static void main(String[] args) {
        int[][] point = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        minCostConnectPoints m = new minCostConnectPoints();
        System.out.println(m.minCostConnectPoints(point));
    }
}
