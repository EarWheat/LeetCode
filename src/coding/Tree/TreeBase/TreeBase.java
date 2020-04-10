package coding.Tree.TreeBase;

import coding.Tree.Tree;

import java.util.Random;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-10 14:04
 * @desc:二叉树基本类
 */
public class TreeBase {

    public TreeBase(){
        Tree tree = buildTree();
    }

    // 随机生成一颗二叉树，返回root节点
    public Tree buildTree(){
        Tree root = new Tree(0);
        Random random = new Random();
        int deep = random.nextInt() % 16;
        makeTree(root,deep);
        return root;
    }

    public void showTree(Tree root){
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
    private Tree makeTree(Tree tree, int deep){
        Random random = new Random();
        if(deep == 0){
            return new Tree(random.nextInt());
        }
        if(tree.left == null){
            tree.left = new Tree(random.nextInt());
        }
        if(tree.right == null){
            tree.right = new Tree(random.nextInt());
        }
        makeTree(tree.left, --deep);
        makeTree(tree.right, --deep);
        return tree;
    }
}
