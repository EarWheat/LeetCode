package leetcode.One.Thousand.minimumAbsDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/4 11:19 AM
 * @Version: 1.initial version; 2022/7/4 11:19 AM
 */
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i + 1] - arr[i];
            if(temp < min){
                min = temp;
                result.clear();
                List<Integer> t = new ArrayList<>();
                t.add(arr[i]);
                t.add(arr[i + 1]);
                result.add(t);
            } else if(temp == min){
                List<Integer> t = new ArrayList<>();
                t.add(arr[i]);
                t.add(arr[i + 1]);
                result.add(t);
            }
        }
        return result;
    }
}
