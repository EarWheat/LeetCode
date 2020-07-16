package leetcode.isBipartite;

import java.util.ArrayList;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-16 17:16
 * @desc:给定一个无向图graph，当这个图为二分图时返回true。

如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。

graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。


示例 1:
输入: [[1,3], [0,2], [1,3], [0,2]]
输出: true
解释:
无向图如下:
0----1
|    |
|    |
3----2
我们可以将节点分成两组: {0, 2} 和 {1, 3}。

示例 2:
输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
输出: false
解释:
无向图如下:
0----1
| \  |
|  \ |
3----2
我们不能将节点分割成两个独立的子集。
*A:{1,2,3}
*B:{0,2}
思路：
* 维护
 */
public class isBipartite {
    public static boolean isBipartite(int[][] graph) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        // 每一个节点
        for(int i = 0; i < graph.length; i++){
            // 每一个节点
            int[] temp = graph[i];
            if(listA.contains(i)){
                for (int value : temp) {
                    if(listA.contains(value)){
                        return false;
                    }
                    if (!listB.contains(value)) {
                        listB.add(value);
                    }
                }
            }  else {
                for (int value : temp) {
                    if(listB.contains(value)){
                        return false;
                    }
                    if (!listA.contains(value)) {
                        listA.add(value);
                    }
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        /*
            0---1
               /
              /
             /
            3---2
            {0,3},{1,2}
         */
        int[][] graph2 = new int[][]{{1},{0,3},{3},{1,2}};
        System.out.println(isBipartite(graph2));
    }
}
