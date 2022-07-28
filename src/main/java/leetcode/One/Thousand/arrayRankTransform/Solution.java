package leetcode.One.Thousand.arrayRankTransform;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/28 4:29 PM
 * @Version: 1.initial version; 2022/7/28 4:29 PM
 */
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] newArray = arr.clone();
        Arrays.sort(newArray);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < newArray.length; i++) {
            if(!map.containsKey(newArray[i])){
                map.put(newArray[i], rank);
                rank++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = map.get(arr[i]);
        }
        return newArray;
    }
}
