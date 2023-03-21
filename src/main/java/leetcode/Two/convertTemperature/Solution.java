package leetcode.Two.convertTemperature;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/3/21 6:39 PM
 * @Version: 1.initial version; 2023/3/21 6:39 PM
 */
public class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
