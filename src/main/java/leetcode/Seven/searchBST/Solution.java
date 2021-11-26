package leetcode.Seven.searchBST;

import leetcode.Util.TreeNode;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/11/26 2:58 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/26 2:58 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val == val){
            return root;
        }
        if(root.val < val && root.right != null){
            return searchBST(root.right, val);
        }
        if(root.val > val && root.left != null){
            return searchBST(root.left, val);
        }
        return null;
    }
}
