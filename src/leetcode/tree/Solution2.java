package leetcode.tree;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-01 17:16
 * @desc:
 */
public class Solution2 {
    public int run(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left != null && root.right != null){
            return Math.min(run(root.left),run(root.right)) + 1;
        } else if(root.left != null){
            return run(root.left) + 1;
        } else {
            return run(root.right) + 1;
        }
    }
}
