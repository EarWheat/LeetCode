package leetcode.One.Thousand.numWaterBottles;

/**
 * @author ：liuzhaolu
 * @description：1518. 换酒问题
 * @prd : https://leetcode-cn.com/problems/water-bottles/
 * @date ：2021/12/17 3:09 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/17 3:09 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = numBottles;
        int result = numBottles;
        while (emptyBottles >= numExchange){
            int temp = 0;
            temp = emptyBottles / numExchange;
            emptyBottles = emptyBottles % numExchange + temp;
            result += temp;
        }
        return result;
    }
}
