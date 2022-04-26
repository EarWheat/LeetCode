package Interview.mirrorTree;

import leetcode.Util.TreeNode;

/**
 * @author ：liuzhaolu
 * @description：剑指 Offer 27. 二叉树的镜像
 * @prd : https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @date ：2022/4/26 2:32 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/26 2:32 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
