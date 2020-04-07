package coding.Newke.byteDance;

import UtilClass.Tree;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-07 14:49
 * @desc:给定一个二叉树，求出该二叉树中任意两个节点的最远距离（两个节点的距离是指两个节点之间边的条数，可能不过根节点。）

如下图所示的二叉树的最远距离是3

          1
         / \
        2   3
       / \   \
      4   5   6
           \
            7
 */
public class MaxTreeNodeLength {
    public static void main(String[] args) {
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        Tree tree4 = new Tree(4);
        Tree tree5 = new Tree(5);
        Tree tree6 = new Tree(6);
        Tree tree7 = new Tree(7);
        tree1.setLeft(tree2);
        tree1.setRight(tree3);
        tree2.setLeft(tree4);
        tree2.setRight(tree5);
        tree3.setRight(tree6);
        tree5.setRight(tree7);
//        System.out.println(maxDeep(tree1));
        System.out.println(maxLength(tree1));

        Tree root=new Tree(0);
        Tree p1=new Tree(1);
        Tree p2=new Tree(2);
        Tree p3=new Tree(3);
        Tree p4=new Tree(4);
        Tree p5=new Tree(5);
        Tree p6=new Tree(6);
        Tree p7=new Tree(7);
        Tree p8=new Tree(8);
        root.left=p1;
        root.right=p2;
        p1.left=p3;
        p3.left=p4;
        p2.left=p5;
        p2.right=p6;
        p6.right=p7;
        p7.right=p8;
        System.out.println(maxLength(root));

        Tree A=new Tree(0);
        Tree B=new Tree(1);
        Tree C=new Tree(2);
        Tree D=new Tree(3);
        Tree E=new Tree(4);
        Tree F=new Tree(5);
        Tree G=new Tree(6);
        Tree H=new Tree(7);
        Tree O = new Tree(8);
        A.left=B;
        A.right=O;
        B.left=C;
        B.right=D;
        C.left=E;
        E.left=G;
        D.right=F;
        F.right=H;
        System.out.println(maxLength(A));

    }

    private static int maxLength(Tree root){
        int maxLeft = 0;
        int maxRight = 0;
        if(root.getLeft() != null){
            maxLeft = maxDeep(root.getLeft());
        } if(root.getRight() != null){
            maxRight = maxDeep(root.getRight());
        }
        int result = maxLeft + maxRight + 2;
        if(root.getLeft() != null){
            result = Math.max(result,maxLength(root.getLeft()));
        }
        if(root.getRight() != null){
            result = Math.max(result,maxLength(root.getRight()));
        }
        return result;
    }

    // 求树的最大深度
    private static int maxDeep(Tree root){
//        int deep = 0;
        int deepLeft = 0;
        int deepRight = 0;
        if (root.getLeft() != null){
            deepLeft++;
            deepLeft = maxDeep(root.getLeft()) + deepLeft;
        }
        if(root.getRight() != null){
            deepRight++;
            deepRight = maxDeep(root.getRight()) + deepRight;
        }
        return Math.max(deepLeft,deepRight);
    }

    private static int maxRightLength(Tree root){
        return 1;
    }

    private static int maxLeftLength(Tree root){
        return 1;
    }
}
