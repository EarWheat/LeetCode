package leetcode.One.Thousand.destCity;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/1 5:10 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Boolean> stations = new HashMap<>();
        paths.forEach(path -> {
            stations.put(path.get(0), true);
            if(!stations.containsKey(path.get(1))){
                stations.put(path.get(1), false);
            }
        });
        for(Map.Entry<String, Boolean> entry : stations.entrySet()){
            if(!entry.getValue()){
                return entry.getKey();
            }
        }
        return "";
    }
}
