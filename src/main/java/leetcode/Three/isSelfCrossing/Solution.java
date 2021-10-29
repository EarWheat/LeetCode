package leetcode.Three.isSelfCrossing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：liuzhaolu
 * @date ：2021/10/29 5:05 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/10/29      liuzhaolu       firstVersion
 */
public class Solution {

    public boolean isSelfCrossing(int[] distance) {
        Set<int[]> points = new HashSet<>();
        int[] startPoints = new int[]{0,0};
        points.add(startPoints);
        Set<int[]> temp = new HashSet<>();
        for (int i = 0; i < distance.length; i++) {
            temp = getPoints(startPoints, i % 4, distance[i]);
            for (int[] ints : temp) {
                if (points.contains(ints)) {
                    return true;
                }
                startPoints = ints;
            }
            points.addAll(temp);
        }
        return false;
    }

    /**
     *
     * @param point 起点
     * @param face 方向；0:上，1：左，2：下，3：右
     * @param distance 距离
     * @return
     */
    public Set<int[]> getPoints(int[] point, int face, int distance){
        Set<int[]> result = new HashSet<>();
        if(face == 0){
            for (int i = 0; i < distance; i++) {
                int[] newPoint = new int[2];
                newPoint[0] = point[0];
                newPoint[1] = point[1] + i;
                result.add(newPoint);
            }
        }
        if(face == 1){
            for (int i = 0; i < distance; i++) {
                int[] newPoint = new int[2];
                newPoint[0] = point[0] - i;
                newPoint[1] = point[1];
                result.add(newPoint);
            }
        }
        if(face == 2){
            for (int i = 0; i < distance; i++) {
                int[] newPoint = new int[2];
                newPoint[0] = point[0];
                newPoint[1] = point[1] - i;
                result.add(newPoint);
            }
        }
        if(face == 3){
            for (int i = 0; i < distance; i++) {
                int[] newPoint = new int[2];
                newPoint[0] = point[0] + i;
                newPoint[1] = point[1];
                result.add(newPoint);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSelfCrossing(new int[]{2,1,1,2}));
    }
}
