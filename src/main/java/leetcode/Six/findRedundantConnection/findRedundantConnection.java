package leetcode.Six.findRedundantConnection;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/13 下午4:06
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class findRedundantConnection {
    /**
     * 计算度为2的数，删除后面的
     * @param edges
     * @return
     */
    public static int[] findRedundantConnection(int[][] edges) {
//        Map<Integer, Integer> degree = new HashMap<>(); // 用来存入key对应的边
        Map<Integer, Set<Integer>> connect = new HashMap<>(); // 用来存key链接的边
        for(int i = 0; i < edges.length; i++){
            int[] temp = edges[i];
            if(connect.containsKey(temp[0])){
                Set<Integer> set = connect.get(temp[0]);
                set.add(temp[1]);
                connect.put(temp[0],set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(temp[1]);
                connect.put(temp[0],set);
            }

            if(connect.containsKey(temp[1])){
                Set<Integer> set = connect.get(temp[1]);
                set.add(temp[0]);
                connect.put(temp[1],set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(temp[0]);
                connect.put(temp[1],set);
            }
        }
        boolean deleteSuccess = true;
        while (deleteSuccess){
            deleteSuccess = deleteConnect(connect);
        }
        return lastConnect(edges,connect);
    }

    /**
     * 删除一条边
     * @param connect
     */
    public static boolean deleteConnect(Map<Integer, Set<Integer>> connect){
        for(Map.Entry<Integer, Set<Integer>> entry : connect.entrySet()){
            Set<Integer> temp = entry.getValue();
            if(temp.size() == 1){
                Integer key = entry.getKey();   // 点A
                Integer value = temp.iterator().next(); // 点B
                connect.remove(key); // 删除点A->点B
                Set<Integer> connected = connect.get(value); // 点B相连的边
                connected.remove(key);  // 从中删除点A
                connect.put(value,connected); // 更新
                return true;
            }
        }
        return false;
    }

    /**
     * 删除最后一条边
     * @param edges
     * @param connect
     * @return
     */
    public static int[] lastConnect(int[][] edges, Map<Integer, Set<Integer>> connect){
        for (int i = edges.length - 1; i >= 0; i--) {
            int[] temp = edges[i];
            if(connect.containsKey(temp[0]) && connect.containsKey(temp[1])){
                return temp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,4},{3,4},{1,3},{1,2},{4,5}};
        System.out.println(JSONObject.toJSONString(findRedundantConnection(edges)));
    }
}
