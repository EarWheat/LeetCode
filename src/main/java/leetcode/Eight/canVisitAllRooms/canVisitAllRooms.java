package leetcode.Eight.canVisitAllRooms;

import java.util.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-31 14:07
 * @desc:
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。

在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。

最初，除 0 号房间外的其余所有房间都被锁住。

你可以自由地在房间之间来回走动。

如果能进入每个房间返回 true，否则返回 false。

示例 1：

输入: [[1],[2],[3],[]]
输出: true
解释:
我们从 0 号房间开始，拿到钥匙 1。
之后我们去 1 号房间，拿到钥匙 2。
然后我们去 2 号房间，拿到钥匙 3。
最后我们去了 3 号房间。
由于我们能够进入每个房间，我们返回 true。
示例 2：

输入：[[1,3],[3,0,1],[2],[0]]
输出：false
解释：我们不能进入 2 号房间。
提示：

1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
所有房间中的钥匙数量总计不超过 3000。

 */
public class canVisitAllRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        List<Integer> firstRoom = rooms.get(0);
        visited[0] = true;
        Set<Integer> keys = new HashSet<>(firstRoom);
        visit(visited, keys,rooms);
        for(int i = 0; i < visited.length;i++){
            // 有未参观的房间
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    private static void visit(boolean[] visited, Set<Integer> keys, List<List<Integer>> rooms){
        if(keys.size() == 0){
            return;
        }
        Set<Integer> newKey = new HashSet<>();
        for(Integer key:keys){
            // 未抵达过该房间
            if(!visited[key]){
               // 获得新钥匙
               List<Integer> newKeys = rooms.get(key);
               for(Integer k : newKeys){
                   if(!keys.contains(k)){
                       newKey.add(k);
                   }
               }
               visited[key] = true;
            }
        }
        visit(visited,newKey,rooms);
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
//        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
//        list2.add(3);
//        list2.add(0);
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        List<Integer> list4 = new ArrayList<>();
//        list4.add(0);
        List<List<Integer>> testList = new ArrayList<>();
        testList.add(list1);
        testList.add(list2);
        testList.add(list3);
        testList.add(list4);
        System.out.println(canVisitAllRooms(testList));
    }
}
