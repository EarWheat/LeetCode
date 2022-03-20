package leetcode.Two.isSubStructure;

import leetcode.Util.TreeNode;

/**
 * @author ：liuzhaolu
 * @description：剑指 Offer 26. 树的子结构
 * @prd : https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * @date ：2022/3/20 1:58 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/20 1:58 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (isSameTree(A, B)) {
            return true;
        }
        if (A.left != null && isSameTree(A.left, B)) {
            return true;
        }
        if (A.right != null && isSameTree(A.right, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null && B != null) {
            return false;
        }
        if (A != null && B == null) {
            return false;
        }
        if (A.val == B.val) {
            return isSameTree(A.left, B.left) || isSameTree(A.right, B.right);
        }
        return false;
    }
}
