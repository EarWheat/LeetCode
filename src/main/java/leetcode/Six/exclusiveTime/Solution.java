package leetcode.Six.exclusiveTime;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @Desc: 636. 函数的独占时间
 * @Author: 泽露
 * @Date: 2022/8/7 4:39 PM
 * @Version: 1.initial version; 2022/8/7 4:39 PM
 */
public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        List<String> methodQueue = new ArrayList<>();
        logs.forEach(str -> {
            String[] split = str.split(":");
            int id = Integer.parseInt(split[0]);
            String method = split[1];
            int time = Integer.parseInt(split[2]);
            if (method.equals("start")) {
                methodQueue.add(str);
            } else {
                String m = methodQueue.get(methodQueue.size() - 1);
                String[] splitM = m.split(":");
                int exclusive = time - Integer.parseInt(splitM[2]) + 1;
                result[id] += exclusive;
                methodQueue.remove(methodQueue.size() - 1);
                if(methodQueue.size() > 0){
                    String temp = methodQueue.get(methodQueue.size() - 1);
                    String[] splitTemp = temp.split(":");
                    int tempId = Integer.parseInt(splitTemp[0]);
                    result[tempId] -= exclusive;
                }
            }
        });
        return result;
    }

    public int[] exclusiveTimeAnswer(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[2]);
            if ("start".equals(split[1])) {
                stack.push(new int[]{id, time});
            } else {
                int[] pop = stack.pop();
                int interval = time - pop[1] + 1;
                res[pop[0]] += interval;
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] -= interval;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("0:start:1");
        logs.add("0:start:2");
        logs.add("0:end:3");
        logs.add("0:end:4");
        logs.add("0:end:5");
        System.out.println(Arrays.toString(solution.exclusiveTime(1, logs)));
    }

}
