package leetcode.Seven.minDiffInBST;

import leetcode.Util.TreeNode;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/13 下午10:17
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.right == null && root.left == null){
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        if(root.left != null){
            min = Math.min(min, root.val - TreeMax(root.left));
            min = Math.min(min, minDiffInBST(root.left));
        }
        if(root.right != null){
            min = Math.min(min, TreeMin(root.right) - root.val);
            min = Math.min(min, minDiffInBST(root.right));
        }
        return min;
    }

    public int TreeMax(TreeNode root){
        int max = root.val;
        while (root != null){
            max = root.val;
            root = root.right;
        }
        return max;
    }

    public int TreeMin(TreeNode root){
        int min = root.val;
        while (root != null){
            min = root.val;
            root = root.left;
        }
        return min;
    }
}
