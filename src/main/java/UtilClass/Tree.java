package UtilClass;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-07 14:49
 * @desc:
 */
public class Tree {
    int value;
    public Tree(int value){
        this.value = value;
    }
    public Tree left;
    public Tree right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

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
