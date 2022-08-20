package leetcode.Six.constructMaximumBinaryTree;

import leetcode.Util.TreeNode;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/20 10:42 AM
 * @Version: 1.initial version; 2022/8/20 10:42 AM
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
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
}
