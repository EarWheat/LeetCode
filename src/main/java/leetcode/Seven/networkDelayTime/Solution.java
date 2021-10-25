package leetcode.Seven.networkDelayTime;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/2 3:22 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    private Set<Integer> visited = new HashSet<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

//    public int networkDelayTime(int[][] times, int n, int k) {
//        if(times.length <= 0){
//            return -1;
//        }
//        int start = times[0][0];
//        if(start != k){
//            return -1;
//        }
//        Map<Integer, List<int[]>> pointMap= new HashMap<>();
//        for (int i = 0; i < times.length; i++) {
//            int[] temp = times[i];
//            List<int[]> list;
//            int[] connectPoint = new int[2];
//            if(pointMap.containsKey(temp[0])){
//                list = pointMap.get(temp[0]);
//            } else {
//                list = new ArrayList<>();
//            }
//            connectPoint[0] = temp[1];
//            connectPoint[1] = temp[2];
//            list.add(connectPoint);
//            pointMap.put(temp[0],list);
//        }
//        Stack<Integer> startPoint = new Stack<>();
//        startPoint.add(k);
//        int result = calculate(pointMap,startPoint);
//        if(visited.size() != n){
//            return -1;
//        }
//        return result;
//    }

//    public int calculate(Map<Integer, List<int[]>> pointMap, Stack<Integer> point){
//        int result = 0;
//        if(point.empty()){
//            return result;
//        }
//        Stack<Integer> newStack = new Stack<>();
//        while (!point.empty()){
//            int p = point.pop();
//            visited.add(p);
//            if(pointMap.containsKey(p)){
//                List<int[]> list = pointMap.get(p);
//                for(int[] connect : list){
//                    if(connect != null){
//                        int toPoint = connect[0];
//                        if(!visited.contains(toPoint)){
//                            newStack.add(toPoint);
//                        }
//                        result+=toPoint;
//                    }
//                }
//            }
//        }
//        return result+calculate(pointMap,newStack);
//    }

    public static void main(String[] args) {
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        Solution solution = new Solution();
        System.out.println(solution.networkDelayTime(times,4,2));
    }
}
