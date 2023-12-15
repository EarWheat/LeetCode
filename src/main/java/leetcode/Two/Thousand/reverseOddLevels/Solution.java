package leetcode.Two.Thousand.reverseOddLevels;

import leetcode.Util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Desc: 反转二叉树的奇数层
 * @Author: 泽露
 * @Date: 2023/12/15 6:30 PM
 * @Version: 1.initial version; 2023/12/15 6:30 PM
 */
public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        boolean isOdd = false;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<TreeNode> arr = new ArrayList<TreeNode>();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (isOdd) {
                    arr.add(node);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (isOdd) {
                for (int l = 0, r = sz - 1; l < r; l++, r--) {
                    int temp = arr.get(l).val;
                    arr.get(l).val = arr.get(r).val;
                    arr.get(r).val = temp;
                }
            }
            isOdd ^= true;
        }
        return root;
    }
}
