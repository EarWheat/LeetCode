package coding.Tree;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-10 14:03
 * @desc:二叉树
 */
public class Tree {
    int value;
    public Tree left;
    public Tree right;

    public Tree(){}
    public Tree(int x) { value = x; }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
