package leetcode.One.buildTree;

import leetcode.Util.TreeNode;
import org.checkerframework.checker.units.qual.A;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/26 1:52 PM
 * @Version: 1.initial version; 2022/6/26 1:52 PM
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        Solution solution = new Solution();
        System.out.println(solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
