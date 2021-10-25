package leetcode.Tree.buildTree;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-25 11:47
 * @desc
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class buildTree {
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode treeNode = new TreeNode(rootVal);
        if(inorder.length == postorder.length && inorder.length == 1){
            return treeNode;
        }
        int index;
        for(index =0; index < inorder.length;index++){
            if(inorder[index] == rootVal){
                int[] inorderLeftArray = Arrays.copyOfRange(inorder,0,index);
                int[] inorderRightArray = Arrays.copyOfRange(inorder,index + 1,inorder.length);
                int[] postorderLeftArray = Arrays.copyOfRange(postorder,0,inorderLeftArray.length);
                int[] postorderRightArray = Arrays.copyOfRange(postorder,inorderLeftArray.length, postorder.length - 1);
                treeNode.left =buildTree(inorderLeftArray,postorderLeftArray);
                treeNode.right = buildTree(inorderRightArray,postorderRightArray);
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,3,15,20,7};
        int[] b = new int[]{9,15,7,20,3};
        TreeNode treeNode = buildTree(a,b);
        System.out.println(treeNode.val);
    }
}
