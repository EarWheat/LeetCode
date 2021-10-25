package leetcode.Tree.MirrorTree;


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
        if(root.left == null && root.right == null)
        {
            return;
        }
        TreeNode temp;
        temp = root.right;
    }
}
