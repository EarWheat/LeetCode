package leetcode.Five.validSquare;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/29 4:00 PM
 * @Version: 1.initial version; 2022/7/29 4:00 PM
 */
public class Solution {
    // 任选3点都能组成直角三角形
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //如果是正方形，则取出三个点一定能构成直角(为了避免四个角为直角的长方形，则需要四个边长都相等，且边长不等于0)
        return suqare(p1,p2,p3) && suqare(p1,p2,p4) && suqare(p1,p3,p4) && suqare(p2,p3,p4);
    }

    public boolean suqare(int [] a, int [] b, int [] c){
        //计算三边长
        int ab = (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
        int ac = (a[0] - c[0]) * (a[0] - c[0]) + (a[1] - c[1]) * (a[1] - c[1]);
        int bc = (c[0] - b[0]) * (c[0] - b[0]) + (c[1] - b[1]) * (c[1] - b[1]);

        //判断直角(因为不知道斜边 所以需要三个判断)
        if(ab + ac == bc){
            return ab == ac && ac != 0;
        }else if (ab + bc == ac){
            return ab == bc && ab != 0;
        }else if(ac + bc == ab){
            return ac == bc && ac != 0;
        }
        return false;
    }
}
