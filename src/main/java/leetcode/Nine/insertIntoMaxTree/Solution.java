package leetcode.Nine.insertIntoMaxTree;

import leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc: 998 最大二叉树
 * @Author: 泽露
 * @Date: 2022/8/30 10:39 AM
 * @Version: 1.initial version; 2022/8/30 10:39 AM
 */
public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> list = tree2Array(root);
        list.add(val);
        return constructMaximumBinaryTree(list.toArray(new Integer[0]));
    }

    public TreeNode constructMaximumBinaryTree(Integer[] nums) {
        if(nums.length == 0) {
            return null;
        }
        int index = 0;
        int max = nums[index];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        return root;
    }

    public List<Integer> tree2Array(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root.left != null) {
            List<Integer> list = tree2Array(root.left);
            result.addAll(list);
        }
        result.add(root.val);
        if (root.right != null) {
            List<Integer> list = tree2Array(root.right);
            result.addAll(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node4.left = node1;
        node4.right = node3;
        node3.left = node2;
        Solution solution = new Solution();
        System.out.println(solution.tree2Array(node4));
    }
}
