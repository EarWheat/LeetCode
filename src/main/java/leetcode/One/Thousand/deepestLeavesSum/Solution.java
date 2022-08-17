package leetcode.One.Thousand.deepestLeavesSum;

import leetcode.Util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/17 4:22 PM
 * @Version: 1.initial version; 2022/8/17 4:22 PM
 */
public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()){
            Queue<TreeNode> queueTemp = new ArrayDeque<>();
            while (!queue.isEmpty()){
                TreeNode treeNode = queue.poll();
                result += treeNode.val;
                if(treeNode.left != null){
                    queueTemp.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queueTemp.add(treeNode.right);
                }
            }
            queue = queueTemp;
            if(!queue.isEmpty()){
                result = 0;
            }
        }
        return result;
    }
}
