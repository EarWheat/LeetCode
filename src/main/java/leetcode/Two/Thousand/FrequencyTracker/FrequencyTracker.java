package leetcode.Two.Thousand.FrequencyTracker;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2024/3/21 7:43 PM
 * @Version: 1.initial version; 2024/3/21 7:43 PM
 */
public class FrequencyTracker {

    Map<Integer, Integer> trackerMap;

    public FrequencyTracker() {
        trackerMap = new HashMap<>();
    }

    public void add(int number) {
        if (trackerMap.containsKey(number)) {
            trackerMap.put(number, trackerMap.get(number) + 1);
        } else {
            trackerMap.put(number, 1);
        }
    }

    public void deleteOne(int number) {
        if (trackerMap.containsKey(number)) {
            trackerMap.put(number, trackerMap.get(number) - 1);
        }
    }

    public boolean hasFrequency(int frequency) {
        for (Map.Entry<Integer, Integer> entry : trackerMap.entrySet()) {
            if (entry.getValue() == frequency) {
                return true;
            }
        }
        return false;
    }
}
