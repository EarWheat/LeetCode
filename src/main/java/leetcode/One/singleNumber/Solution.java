package leetcode.One.singleNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/30 下午2:22
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int singleNumber(int[] nums) {
        Arrays.stream(nums).forEach(this::updateMap);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }

    public void updateMap(int num){
        if(map.containsKey(num)){
            map.put(num,map.get(num) + 1);
        } else {
            map.put(num,1);
        }
    }
}
