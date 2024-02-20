package leetcode.One.buildTree2;

import leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2024/2/20 11:05 AM
 * @Version: 1.initial version; 2024/2/20 11:05 AM
 */
public class Solution {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        TreeNode node = new TreeNode(rootVal);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
            }
        }
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + index), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.buildTree(new int[]{-1}, new int[]{-1});
        TreeNode node2 = solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(node2.toString());
    }
}
