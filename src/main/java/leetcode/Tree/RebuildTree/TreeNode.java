package leetcode.Tree.RebuildTree;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-21 16:08
 * @desc:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
