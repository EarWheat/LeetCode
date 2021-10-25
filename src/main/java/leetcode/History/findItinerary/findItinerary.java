package leetcode.History.findItinerary;

import java.util.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-27 11:49
 * @desc:
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。

说明:

如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
所有的机场都用三个大写字母表示（机场代码）。
假定所有机票至少存在一种合理的行程。
示例 1:

输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
示例 2:

输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。

 */
public class findItinerary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> visited = new ArrayList<>();
        visited.add("JFK");
        return makeTrip(tickets,"JFK",visited);
    }

    private static List<String> makeTrip(List<List<String>> tickets, String location, List<String> visited){
        //  没有机票
        if(tickets.size() == 0){
            return visited;
        }
        // 目的地集合
        List<String> dest = new ArrayList<>();
        for(List<String> ticket: tickets){
            if(ticket.get(0).equals(location)){
                // 添加可到达的目的地
                dest.add(ticket.get(1));
            }
        }
        // 没有目的地
        if(dest.size() == 0){
            return visited;
        }
        // 目的地排序

        String go = dest.get(0);
        for(String to: dest){
            go = to.compareTo(go) < 0 ? to : go;
        }
        // 添加到目的地
        visited.add(go);
        // 销毁机票
        for(int i = 0; i < tickets.size();i++){
            if(tickets.get(i).get(0).equals(location) && tickets.get(i).get(1).equals(go)){
                tickets.remove(i);
                break;
            }
        }
        // 继续旅行
        visited = makeTrip(tickets,go,visited);
        return visited;
    }


    public static void main(String[] args) {
        /**
         * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
         */
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket1 = new ArrayList<>();
        ticket1.add("JFK");
        ticket1.add("SFO");
        tickets.add(ticket1);
        List<String> ticket2 = new ArrayList<>();
        ticket2.add("JFK");
        ticket2.add("ATL");
        tickets.add(ticket2);
        List<String> ticket3 = new ArrayList<>();
        ticket3.add("SFO");
        ticket3.add("ATL");
        tickets.add(ticket3);
        List<String> ticket4 = new ArrayList<>();
        ticket4.add("ATL");
        ticket4.add("JFK");
        tickets.add(ticket4);
        List<String> ticket5 = new ArrayList<>();
        ticket5.add("ATL");
        ticket5.add("SFO");
        tickets.add(ticket5);
        List<String> result = findItinerary(tickets);
        System.out.println(result.toString());
    }
}
