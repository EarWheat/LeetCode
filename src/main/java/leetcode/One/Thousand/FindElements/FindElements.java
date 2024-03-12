package leetcode.One.Thousand.FindElements;

import leetcode.Util.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Desc: 1261. 在受污染的二叉树中查找元素
 * @Author: 泽露
 * @Date: 2024/3/12 11:36 AM
 * @Version: 1.initial version; 2024/3/12 11:36 AM
 */
public class FindElements {

    private TreeNode treeNode;

    private Set<Integer> nodeValues;

    public FindElements(TreeNode root) {
        nodeValues = new HashSet<>();
        treeNode = fillTree(root);
    }

    public boolean find(int target) {
        return nodeValues.contains(target);
    }

    public TreeNode fillTree(TreeNode root) {
        if (root.val == -1) {
            root.val = 0;
            nodeValues.add(0);
        }
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            nodeValues.add(root.left.val);
            root.left = fillTree(root.left);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            nodeValues.add(root.right.val);
            root.right = fillTree(root.right);
        }
        return root;
    }
}
