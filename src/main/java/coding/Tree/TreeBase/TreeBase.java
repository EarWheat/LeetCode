package coding.Tree.TreeBase;


import java.util.Random;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-10 14:04
 * @desc:二叉树基本类
 */
public class TreeBase {

    private int deep;

    public static class Tree{
        int value;
        public Tree left;
        public Tree right;

        Tree(int value) {
            this.value = value;
        }
    }

    // 随机生成一颗二叉树，返回root节点
    protected static Tree buildTree(){
        Random random = new Random();
        Tree root = new Tree(random.nextInt());
        int deep = Math.abs(random.nextInt() % 10);
        makeTree(root, deep, deep);
        return root;
    }

    protected static Tree buildTree(int deep){
        Random random = new Random();
        Tree root = new Tree(random.nextInt());
        makeTree(root, deep, deep);
        return root;
    }

    protected static void showTree(Tree root){
        if(root.left != null){
            System.out.println(root.left);
            showTree(root.left);
        }
        if(root.right != null){
            System.out.println(root.right);
            showTree(root.right);
        }
    }

    // 构建二叉树
    private static void makeTree(Tree tree, int leftDeep, int rightDeep){
        Random random = new Random();
        if(leftDeep == 0 && rightDeep == 0){
            new Tree(random.nextInt());
            return;
        }
        if(tree.left == null){
            tree.left = new Tree(random.nextInt());
        }
        if(tree.right == null){
            tree.right = new Tree(random.nextInt());
        }
        makeTree(tree.left, --leftDeep, rightDeep);
        makeTree(tree.right, leftDeep, --rightDeep);
    }
}
