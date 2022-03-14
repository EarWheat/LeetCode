package leetcode.One.isSymmetric;

import leetcode.Util.TreeNode;

/**
 * @author ：liuzhaolu
 * @description：101. 对称二叉树
 * @prd : https://leetcode-cn.com/problems/symmetric-tree/
 * @date ：2022/3/14 10:38 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/14 10:38 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 != null){
            return false;
        }
        if(node1 != null && node2 == null){
            return false;
        }
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1.val == node2.val){
            return isSame(node1.left, node2.right) && isSame(node1.right, node2.left);
        }
        return false;
    }
}
