package leetcode.History.canFinish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-04 17:10
 * @desc:你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

 

示例 1:

输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。

思路：
* 1、画图
* 2、判断是否有闭合图形
 */
public class canFinish {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        // 存一个节点的入度和出度
//        // <in, 2><out, 3> 表示入度为2，出度为3
//        Map<String, Integer> nodeInfo = new HashMap<>();
//        // 节点信息<1,<in,2>>,<1,<out,3>> 表示节点1入度为2，出度为3
//        Map<Integer, Map<String, Integer>> node = new HashMap<>();
//        // <1,2>节点1的入度为2
//        Map<Integer, Integer> nodeIn = new HashMap<>();
//        // 遍历每一条边
//        for(int[] side: prerequisites){
//            if(nodeIn.containsKey(side[0])){
//                nodeIn.put(side[0],nodeIn.get(side[0] + 1));
//            } else {
//                nodeIn.put(side[0],1);
//            }
//        }
//        return isCanFinish(nodeIn, prerequisites);
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }


    // 更新节点,增加入度
    private void updateNodeIn(Map<Integer, Map<String, Integer>> node, Integer nodeKey){
        // 存一个节点的入度和出度
        // <in, 2><out, 3> 表示入度为2，出度为3
        Map<String, Integer> nodeInfo = new HashMap<>();
        if(node.containsKey(nodeKey)){
            nodeInfo = node.get(nodeKey);
            if(nodeInfo.containsKey("in")){
                nodeInfo.put("in",nodeInfo.get("in") + 1);
            } else {
                nodeInfo.put("in",1);
            }
            node.put(nodeKey,nodeInfo);
        } else {
            nodeInfo.put("in",1);
            nodeInfo.put("out",0);
            node.put(nodeKey,nodeInfo);
        }
    }

    // 更新节点,增加出度
    private void updateNodeOut(Map<Integer, Map<String, Integer>> node, Integer nodeKey){
        // 存一个节点的入度和出度
        // <in, 2><out, 3> 表示入度为2，出度为3
        Map<String, Integer> nodeInfo = new HashMap<>();
        if(node.containsKey(nodeKey)){
            nodeInfo = node.get(nodeKey);
            if(nodeInfo.containsKey("out")){
                nodeInfo.put("out",nodeInfo.get("out") + 1);
            } else {
                nodeInfo.put("out",1);
            }
            node.put(nodeKey,nodeInfo);
        } else {
            nodeInfo.put("out",1);
            nodeInfo.put("in",0);
            node.put(nodeKey,nodeInfo);
        }
    }

}
