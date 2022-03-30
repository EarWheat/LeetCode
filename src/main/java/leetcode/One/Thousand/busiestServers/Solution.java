package leetcode.One.Thousand.busiestServers;

import UtilClass.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author ：liuzhaolu
 * @description：1606. 找到处理最多请求的服务器
 * @prd : https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/
 * @date ：2022/3/30 2:51 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/30 2:51 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Server> servers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Server server = new Server(i);
            servers.add(server);
        }
        for (int i = 0; i < arrival.length; i++) {
            Server server = findIdleServer(servers, arrival[i], i);
            // 跳过任务
            if (server == null) {
                continue;
            } else {
                Task task = new Task(arrival[i], arrival[i] + load[i]);
                server.addTask(task);
            }
        }
        TreeMap<Integer, List<Server>> listTreeMap = new TreeMap<>();
        for (Server server : servers) {
            int taskNum = server.getTasks().size();
            if (listTreeMap.containsKey(taskNum)) {
                List<Server> temp = listTreeMap.get(taskNum);
                temp.add(server);
            } else {
                List<Server> temp = new ArrayList<>();
                temp.add(server);
                listTreeMap.put(server.getTasks().size(), temp);
            }
        }
        List<Server> respServers = listTreeMap.get(listTreeMap.lastKey());
        List<Integer> resp = new ArrayList<>();
        respServers.forEach(server -> {
            resp.add(server.getId());
        });
        return resp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.busiestServers(2, new int[]{1,2,3}, new int[]{1000000000,1,1000000000}));
    }

    // 寻找空闲服务
    private Server findIdleServer(List<Server> servers, int time, int no) {
        int index = no % servers.size();
        for (int i = index; i < servers.size(); i++) {
            Server server = servers.get(i);
            if (!server.isBusy(time)) {
                return server;
            }
        }
        for (int i = 0; i < index; i++) {
            Server server = servers.get(i);
            if (!server.isBusy(time)) {
                return server;
            }
        }
        return null;
    }

    private static class Server {
        int id;
        List<Task> tasks;
        Task currentTask;

        Server(int id) {
            this.id = id;
            tasks = new ArrayList<>();
        }

        public void addTask(Task task) {
            tasks.add(task);
            currentTask = task;
        }

        public boolean isBusy(int time) {
            if (this.currentTask == null) {
                return false;
            } else {
                if (time >= currentTask.getEndTime()) {
                    currentTask.setDone(true);
                    currentTask = null;
                    return false;
                } else {
                    return true;
                }
            }
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Task getCurrentTask() {
            return currentTask;
        }

        public void setCurrentTask(Task currentTask) {
            this.currentTask = currentTask;
        }

        public List<Task> getTasks() {
            return tasks;
        }

        public void setTasks(List<Task> tasks) {
            this.tasks = tasks;
        }

    }

    private static class Task {
        int startTime;
        int endTime;
        boolean isDone;

        Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            isDone = false;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public boolean isDone() {
            return isDone;
        }

        public void setDone(boolean done) {
            isDone = done;
        }
    }
}
