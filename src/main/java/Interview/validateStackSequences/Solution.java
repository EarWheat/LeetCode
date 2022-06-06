package Interview.validateStackSequences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/6 4:58 PM
 * @Version: 1.initial version; 2022/6/6 4:58 PM
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Map<Integer, Integer> popMaps = new HashMap<>();
        boolean[] visited = new boolean[popped.length];
        for (int i = 0; i < popped.length; i++) {
            popMaps.put(popped[i], i);
        }
        for (int i = 0; i < popped.length; i++) {
            int temp = popped[i];
            int j = 0;
            while (pushed[j] != temp){
                if(!visited[j] && popMaps.get(pushed[j]) < i){
                    return false;
                }
                j++;
            }
            visited[j] = true;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        // 4,3,5,1,2
        // 1,2,3,4,5
        System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
