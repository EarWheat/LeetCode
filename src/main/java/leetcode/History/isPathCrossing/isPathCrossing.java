package leetcode.History.isPathCrossing;

import java.util.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-28 10:57
 * @desc:
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。

机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。

如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。

输入：path = "NES"
输出：false
解释：该路径没有在任何位置相交。
*

输入：path = "NESWW"
输出：true
解释：该路径经过原点两次。
 */
public class isPathCrossing {
    public static boolean isPathCrossing(String path) {
        Set<String> points = new HashSet<>(); // 点集和
        LinkedList<Integer> currentPoints = new LinkedList<>(); // 当前点位置
        currentPoints.add(0);
        currentPoints.add(0);
        points.add(currentPoints.toString()); // 记录原点
        for(int i = 0; i < path.length(); i++){
            // 北，上移
            if(path.charAt(i) == 'N'){
                currentPoints.set(1,currentPoints.get(1) + 1);    // 上移一个点
                if(points.contains(currentPoints.toString())){
                    return true;
                } else {
                    points.add(currentPoints.toString()); // 未经过记录当前点
                }
            }
            // 南，下移
            if(path.charAt(i) == 'S'){
                currentPoints.set(1,currentPoints.get(1) - 1);    // 下移一个点
                if(points.contains(currentPoints.toString())){
                    return true;
                } else {
                    points.add(currentPoints.toString()); // 未经过记录当前点
                }
            }

            // 东，右移
            if(path.charAt(i) == 'E'){
                currentPoints.set(0,currentPoints.get(0) + 1);;    // 上移一个点
                if(points.contains(currentPoints.toString())){
                    return true;
                } else {
                    points.add(currentPoints.toString()); // 未经过记录当前点
                }
            }

            // 西，左移
            if(path.charAt(i) == 'W'){
                currentPoints.set(0,currentPoints.get(0) - 1);;    // 上移一个点
                if(points.contains(currentPoints.toString())){
                    return true;
                } else {
                    points.add(currentPoints.toString()); // 未经过记录当前点
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPathCrossing("NES"));
        System.out.println(isPathCrossing("NESWW"));
        System.out.println(isPathCrossing("WSSESEEE"));
    }

}
