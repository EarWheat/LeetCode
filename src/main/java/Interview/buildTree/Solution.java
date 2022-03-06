package Interview.buildTree;

import leetcode.Util.TreeNode;
import org.checkerframework.checker.units.qual.A;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：剑指 Offer 07. 重建二叉树
 * @prd : https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @date ：2022/3/4 5:46 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/4 5:46 下午     liuzhaolu       firstVersion
 */
public class Solution {
    // 3, 9, 15, 7, 20
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }
        TreeNode root;
        if (preorder.length < 1) {
            root = new TreeNode(inorder[0]);
            return root;
        }
        root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }
        int index = findIndex(preorder[0], inorder);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + index), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + index, inorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }

    public int findIndex(int x, int[] order) {
        for (int i = 0; i < order.length; i++) {
            if (x == order[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(root.val);
    }
}
