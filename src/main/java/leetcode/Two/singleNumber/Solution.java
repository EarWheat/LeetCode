package leetcode.Two.singleNumber;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：liuzhaolu
 * @date ：2021/10/30 2:54 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/10/30      liuzhaolu       firstVersion
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2){
            return nums;
        }
        Map<Integer, Integer> map =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           if(map.containsKey(nums[i])){
               map.put(nums[i], map.get(nums[i]) + 1);
           } else {
               map.put(nums[i], 1);
           }
        }
        int[] result = new int[2];
        AtomicInteger i = new AtomicInteger();
        map.forEach((k, v) ->{
            if(v == 1){
                result[i.getAndIncrement()] = k;
            }
        });
        return result;
    }
}
