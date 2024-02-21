package leetcode.One.buildTree3;

import leetcode.Util.TreeNode;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2024/2/21 2:02 PM
 * @Version: 1.initial version; 2024/2/21 2:02 PM
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postorder.length - 1]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                index = i;
            }
        }
        node.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder,0, index));
        node.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));
        return node;
    }
}
