package leetcode.Jiaodian;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-12 16:11
 * @desc:
 */
public class Solution {
    public static void main(String[] args) {

    }


    // 求斜率
    private static double getK(int[] point1, int[] point2){
        double k = (point2[1] - point1[1]) / (point2[0] - point1[0]);
        return k;
    }
}
