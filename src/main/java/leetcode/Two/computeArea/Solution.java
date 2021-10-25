package leetcode.Two.computeArea;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/30 4:01 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        int sameArea = getSameArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        return area1 + area2 - sameArea;
    }

    private int getSameArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2){
        if(ax1 > bx2 || ax2 < bx1 || ay1 > by2 || ay2 < by1) {
            return 0;
        }
        int x1 = Math.max(ax1, bx1);
        int x2 = Math.min(ax2, bx2);

        int y1 = Math.max(ay1, by1);
        int y2 = Math.min(ay2, by2);

        return  (x2 - x1) * (y2 - y1);
    }
}
