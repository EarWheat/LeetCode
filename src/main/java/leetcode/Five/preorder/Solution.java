package leetcode.Five.preorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ：liuzhaolu
 * @description：589. N 叉树的前序遍历
 * @prd : https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @date ：2022/3/10 3:15 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/10 3:15 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Node> list = new ArrayList<>();
        list.add(root);
        return pre(list);
    }

    public List<Integer> pre(List<Node> linkedList){
        List<Integer> res = new ArrayList<>();
        if(linkedList == null){
            return res;
        }
        for(Node node : linkedList){
            if(node != null){
                res.add(node.val);
                res.addAll(pre(node.children));
            }
        }
        return res;
    }

    public static class Node {
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
