package leetcode.PointsLine;

import java.util.HashMap;
import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-22 16:31
 * @desc:对于给定的n个位于同一二维平面上的点，求最多能有多少个点位于同一直线上
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class PointsLine {
    public static void main(String[] args){

    }

    public int maxPoints(Point[] points) {

        if(points == null){
            return 0;
        }
        if(points.length <= 2){
            return points.length;
        }
        Map map = new HashMap();
        int result = 0;
        for(int i=0;i<points.length;i++){
            map.clear();
            int overlap = 0;
            int vertical = 0;
            int horizon = 0;
            int max = 0;
            double rate = 0.0;
            for(int j=i+1;j<points.length;j++){
                double gapx = (double) points[i].x - (double) points[j].x;
                double gapy = (double) points[i].y - (double) points[j].y;
                if(gapx == 0 && gapy == 0){
                    overlap++;
                }else if(gapx == 0){
                    vertical++;
                    max = Math.max(max,vertical);
                }else if(gapy == 0){
                    horizon++;
                    max = Math.max(max,horizon);
                }else{
                    rate = gapy/gapx;
                    if(map.containsKey(rate)){
                        map.put(rate,Integer.parseInt(map.get(rate).toString())+1);
                    }else{
                        map.put(rate,1);
                    }
                    max = Math.max(max, (Integer) map.get(rate));
                }
            }
            result=Math.max(result, max+overlap+1);
        }
        return result;
    }

}
