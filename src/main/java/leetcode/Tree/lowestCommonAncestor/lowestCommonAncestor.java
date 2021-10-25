package leetcode.Tree.lowestCommonAncestor;

import UtilClass.Tree;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-27 09:39
 * @desc 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class lowestCommonAncestor {
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    /**
     * 思路从当前节点往下找，如果两个节点分别在左右子树，那么该节点就是最近公共祖先，否则如果两个节点都在左子树就递归左节点，右边就递归右节点。
     * 思路2：中序遍历一下，最近公共祖先就一定在两个节点中间
     * 中序：023456789
     * 后序：035427986
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        if(root == p){
            if(findTree(root,q)){
                return root;
            }
        } else if(root == q){
            if(findTree(root,p)){
                return root;
            }
        }
        if(root.left == null){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(root.right == null){
            return lowestCommonAncestor(root.left,p,q);
        }
        // p,q均在左子树
        if(findTree(root.left,p) && findTree(root.left,q)){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(findTree(root.right,p) && findTree(root.right,q)){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    public static boolean findTree(TreeNode root, TreeNode p){
        if(root == null){
            return false;
        }
        if(root == p){
            return true;
        }
        if(root.left == null && root.right == null){
            return false;
        }
        return findTree(root.right,p) || findTree(root.left, p);
    }

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
//        node6.left = node2;
//        node6.right = node8;
//        node2.left = node0;
//        node2.right = node4;
//        node4.left =node3;
//        node4.right = node5;
//        node8.left = node7;
//        node8.right = node9;
        node2.left = node1;
        TreeNode temp = lowestCommonAncestor(node2,node2,node1);
        System.out.println(temp.val);

    }
}
