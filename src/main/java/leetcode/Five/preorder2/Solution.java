package leetcode.Five.preorder2;

import Interview.treeToDoublyList.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 589. N 叉树的前序遍历
 * @Author: 泽露
 * @Date: 2024/2/18 6:04 PM
 * @Version: 1.initial version; 2024/2/18 6:04 PM
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node ch : root.children) {
            helper(ch, res);
        }
    }

    class Node {
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
