package leetcode.Five.largestValues;

import leetcode.Util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/24 4:26 PM
 * @Version: 1.initial version; 2022/6/24 4:26 PM
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            Queue<TreeNode> newQueue = new ArrayDeque<>();
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                max = Math.max(temp.val, max);
                if(temp.left != null){
                    newQueue.add(temp.left);
                }
                if(temp.right != null){
                    newQueue.add(temp.right);
                }
            }
            result.add(max);
            queue = newQueue;
        }
        return result;
    }
}
