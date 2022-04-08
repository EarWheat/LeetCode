package leetcode.Four.levelOrder;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ：liuzhaolu
 * @description：429. N 叉树的层序遍历
 * @prd : https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * @date ：2022/4/8 11:50 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/8 11:50 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        LinkedBlockingDeque<Node> deque = new LinkedBlockingDeque<>();
        deque.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!deque.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            LinkedBlockingDeque<Node> newQueue = new LinkedBlockingDeque<>();
            while (!deque.isEmpty()){
                Node temp = deque.poll();
                if(temp.children != null){
                    for(Node n: temp.children){
                        newQueue.add(n);
                    }
                }
                tempList.add(temp.val);
            }
            deque = newQueue;
            result.add(tempList);
        }
        return result;
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
