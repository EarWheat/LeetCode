package leetcode.One.levelOrderBottom;

import leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ：liuzhaolu
 * @description：107. 二叉树的层序遍历 II
 * @prd : https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @date ：2022/3/9 2:20 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/9 2:20 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> treeNodes = new LinkedBlockingQueue<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            List<Integer> str= new ArrayList<>();
            Queue<TreeNode> queue = new LinkedBlockingQueue<>();
            while (!treeNodes.isEmpty()){
                TreeNode temp = treeNodes.poll();
                str.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            stack.add(str);
            treeNodes = queue;
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
