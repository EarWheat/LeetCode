package leetcode.tree;

/**
 * 树结构
 * createTime 2019／09／01
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
