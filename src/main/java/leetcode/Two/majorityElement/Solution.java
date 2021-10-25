package leetcode.Two.majorityElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：liuzhaolu
 * @date ：2021/10/22 2:33 下午
 * @desc ：https://leetcode-cn.com/problems/majority-element-ii/
 * @prd Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/10/22      liuzhaolu       firstVersion
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int count = n / 3;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (counter.containsKey(num)) {
                int temp = counter.get(num);
                counter.put(num, temp + 1);
            } else {
                counter.put(num, 1);
            }
        }
        counter.forEach((key, value) -> {
            if(value > count){
                list.add(key);
            }
        });
        return list;
    }

    public static void main(String[] args) {
        System.out.println(8/3);
    }
}
