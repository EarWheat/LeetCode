package leetcode.Nine.distributeCoins;

import leetcode.Util.TreeNode;

/**
 * @Desc: 979. 在二叉树中分配硬币
 * @Author: 泽露
 * @Date: 2023/7/14 4:06 PM
 * @Version: 1.initial version; 2023/7/14 4:06 PM
 */
public class Solution {
    int move = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;
    }

    public int dfs(TreeNode root) {
        int moveleft = 0;
        int moveright = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            moveleft = dfs(root.left);
        }
        if (root.right != null) {
            moveright = dfs(root.right);
        }
        move += Math.abs(moveleft) + Math.abs(moveright);
        return moveleft + moveright + root.val - 1;
    }

}
