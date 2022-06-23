package leetcode.Five.findBottomLeftValue;

import leetcode.Util.TreeNode;
import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/22 4:34 PM
 * @Version: 1.initial version; 2022/6/22 4:34 PM
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode result = null;
        while (!queue.isEmpty()){
            result = queue.peek();
            Queue<TreeNode> temp = new ArrayDeque<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left != null){
                    temp.add(node.left);
                }
                if(node.right != null){
                    temp.add(node.right);
                }
            }
            queue = temp;
        }
        return result != null ? result.val : 0;
    }
}
