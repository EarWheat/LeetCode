package leetcode.MirrorTree;

import leetcode.tree.TreeNode;

/*
 * @author:liuzhaolu
 * @createTime: 2020-01-26 10:54
 * @desc:
 */
public class MirrorTree {
    public static void main(String[] args){

    }

    public void Mirror(TreeNode root) {
        if(root == null)
        {
            return;
        }
        if(root.getLeft() == null && root.getRight() == null)
        {
            return;
        }
        TreeNode temp;
        temp = root.getRight();
    }
}
