package leetcode.Six.scheduleCourse;

import java.util.*;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/12/14 5:01 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/14 5:01 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public static int scheduleCourse(int[][] courses) {
        //排序将关闭时间最晚的放在最后面
        Arrays.sort(courses,Comparator.comparing(a->a[1]));

        //用于储存当前最优课程队列 首位为当前课程最大用时
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

        //当前总计所需时长
        int totalDuration = 0;

        for (int i = 0; i < courses.length; i++) {
            //本次学习需要的时间
            int duration = courses[i][0];
            //本次学习最晚的完成时间
            int lastDay = courses[i][1];
            //学习时间比最晚时间还长 直接忽略
            if (duration > lastDay){
                continue;
            }
            //当前学习时长加上本次学习时长没超过本次的最晚时间 符合要求加入课程队列
            if (totalDuration + duration <= lastDay){
                //加上最长时长
                totalDuration += duration;
                //将最大时长放入队列
                priorityQueue.add(duration);
            }else {
                //当前学习时长加上本次学习超过本次的最晚时间
                //判断当前课程队列里面最长的学习时间是否比本次更长
                if (priorityQueue.size()>0 && (priorityQueue.peek() > duration)){
                    //如果最长的学习时间比本次更长 将替换课程 为后续的课程提供更长的学习时间
                    totalDuration = totalDuration - priorityQueue.poll() + duration;
                    priorityQueue.add(duration);
                }
            }

        }
        return priorityQueue.size();
    }
}
