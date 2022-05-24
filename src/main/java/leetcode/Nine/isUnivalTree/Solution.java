package leetcode.Nine.isUnivalTree;

import leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: https://leetcode.cn/problems/univalued-binary-tree/
 * @Author: 泽露
 * @Date: 2022/5/24 4:42 PM
 * @Version: 1.initial version; 2022/5/24 4:42 PM
 */
public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean result = true;
        if (root.left != null) {
            if (root.val == root.left.val) {
                result = result && isUnivalTree(root.left);
            } else {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val == root.right.val) {
                result = result && isUnivalTree(root.right);
            } else {
                return false;
            }
        }
        return result;

    }
}
