package leetcode.One.Thousand.makeConnected;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/23 下午5:08
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class makeConnected {
    public static int makeConnected(int n, int[][] connections) {
        if(n - connections.length > 1){
            return -1;
        }
        if(n == 0 || connections.length == 0){
            return -1;
        }
        List<Set<Integer>> connected = new ArrayList<>();   // 联通的电脑
        for (int i = 0; i < connections.length; i++) {
            int[] connect = connections[i];
            if(connected.size() > 0){
                boolean merged = false;
                for(Set<Integer> c : connected){
                    if(c.contains(connect[0]) || c.contains(connect[1])){
                        c.add(connect[0]);
                        c.add(connect[1]);
                        merged = true;
                        break;
                    }
                }
                if(!merged){
                    Set<Integer> set = new HashSet<>();
                    set.add(connect[0]);
                    set.add(connect[1]);
                    connected.add(set);
                }
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(connect[0]);
                set.add(connect[1]);
                connected.add(set);
            }
        }
        boolean[] isConnected = new boolean[n];
        int result = 0;
        for (Set<Integer> c : connected){
            for(Integer i : c){
                if(isConnected[i]){
                    result--;
                }
                isConnected[i] = true;
            }
        }
        for (int i = 0; i < isConnected.length; i++) {
            if(!isConnected[i]){
                result++;
            }
        }
        return result + connected.size() - 1;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0,1},{0,2},{3,4},{2,3}};
        System.out.println(makeConnected(5,test));
    }
}
