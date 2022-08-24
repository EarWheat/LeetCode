package leetcode.One.canBeEqual;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: 1460. 通过翻转子数组使两个数组相等
 * @Author: 泽露
 * @Date: 2022/8/24 3:26 PM
 * @Version: 1.initial version; 2022/8/24 3:26 PM
 */
public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> arrMap = new HashMap<>();
        Arrays.stream(arr).forEach(i -> {
            arrMap.put(i, arrMap.getOrDefault(i, 0) + 1);
        });
        Map<Integer, Integer> targetMap = new HashMap<>();
        Arrays.stream(target).forEach(i -> {
            targetMap.put(i, targetMap.getOrDefault(i, 0) + 1);
        });
        for (Map.Entry<Integer, Integer> entry : arrMap.entrySet()) {
            Integer key = entry.getKey();
            if (!entry.getValue().equals(targetMap.get(key))) {
                return false;
            }
        }
        return true;
    }
}
