package leetcode.Five.maxDepth;

import java.util.List;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/21 9:25 上午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/21      liuzhaolu       firstVersion
 */
public class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        if(root.children == null){
            return 1;
        }
        List<Node> child = root.children;
        int result = 0;
        for(Node node : child){
            result = Math.max(result, 1 + maxDepth(node));
        }
        return result;
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
