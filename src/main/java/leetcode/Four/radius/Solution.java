package leetcode.Four.radius;


import java.util.Random;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/5 10:32 AM
 * @Version: 1.initial version; 2022/6/5 10:32 AM
 */
public class Solution {

    private double radius;
    private double x_center;
    private double y_center;


    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        Random random = new Random();
        double[] result = new double[2];
        double x = -1;
        double y = -1;
        while (!isRadio(x, y)){
            x = random.nextDouble() % radius + x_center;
            y = random.nextDouble() % radius + y_center;
        }
        result[0] = x;
        result[1] = y;
        return result;
    }

    public boolean isRadio(double x, double y){
        double line = Math.sqrt(Math.pow(Math.abs(x-x_center),2) + Math.pow(Math.abs(y - y_center), 2));
        return line < radius;
    }
}
