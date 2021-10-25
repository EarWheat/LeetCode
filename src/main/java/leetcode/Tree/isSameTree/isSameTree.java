package leetcode.Tree.isSameTree;

import UtilClass.Tree;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-07 10:05
 * @desc:
 * 给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
示例 2:

输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false

 */
public class isSameTree {

    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    /**
     * 思路：
     * 因为根据前序和中序遍历能唯一确定一棵树，所以只要一颗树的前序遍历和中序遍历相同，就一定是同一颗树
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return qianxu(p).equals(qianxu(q)) && zhongxu(p).equals(zhongxu(q));
    }

    // 前序遍历
    private static String qianxu(TreeNode root){
        String result = "";
        if(root == null){
            return result += "null";
        }
        if(root.left == null && root.right == null){
            return result += String.valueOf(root.val);
        }
        // 根
        result += String.valueOf(root.val);
        // 左
        if(root.left != null){
            result += qianxu(root.left);
        } else {
            result += "null";
        }
        // 右
        if(root.right != null){
            result += qianxu(root.right);
        } else {
            result += "null";
        }
        return result;
    }

    // 中序遍历
    private static String zhongxu(TreeNode root){
        String result = "";
        if(root == null){
            return result += "null";
        }
        if(root.left == null && root.right == null){
            return result += String.valueOf(root.val);
        }
        // 左
        if(root.left != null){
            result += qianxu(root.left);
        } else {
            result += "null";
        }
        // 根
        result += String.valueOf(root.val);
        // 右
        if(root.right != null){
            result += qianxu(root.right);
        } else {
            result += "null";
        }
        return result;
    }

    public boolean answer(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }

        if(p!=null && q!=null && p.val==q.val  ){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root_p = new TreeNode(1);
        TreeNode root_q = new TreeNode(1);
        root_p.left = new TreeNode(1);
        root_q.right = new TreeNode(1);
        System.out.println(qianxu(root_p));
        System.out.println(qianxu(root_q));
    }
}
