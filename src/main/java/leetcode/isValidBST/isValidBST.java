package main.java.leetcode.isValidBST;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-05 08:46
 * @desc:给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   7
     / \
    3   8
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

* 输入:
    6
   / \
  5   8
 / \
4   7
*
* 答案：中序遍历为升序
 */
public class isValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
//        System.out.println(isValidBST(root));
        TreeNode root1 = new TreeNode(5);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(7);
        TreeNode rightLeft = new TreeNode(3);
        TreeNode rightRight = new TreeNode(8);
        root1.left = left1;
        root1.right = right1;
        right1.left = rightLeft;
        right1.right = rightRight;
//        System.out.println(isValidBST(root1));
        /**
         *     7             5
         *    / \           / \
         *   5   8         1  17
         *  / \              / \
         * 3  6            13  19
         *                / \
         *               4  18
         */
        TreeNode root3 = new TreeNode(7);
        TreeNode left3 = new TreeNode(5);
        TreeNode leftleft3 = new TreeNode(3);
        TreeNode leftright3 = new TreeNode(6);
        TreeNode right3 = new TreeNode(8);
        root3.left = left3;
        root3.right = right3;
        left3.left = leftleft3;
        left3.right = leftright3;
//        System.out.println(isValidBST(root3));
        TreeNode treeNode = null;
//        System.out.println(isValidBST(treeNode));
        /**
         *                    3
         *                 /    \
         *                1      5
         *               / \    / \
         *              0  2   4   6
         *                          \
         *                           3
         */
        TreeNode root5 = new TreeNode(3);
        TreeNode left5 = new TreeNode(1);
        TreeNode left5left = new TreeNode(0);
        TreeNode left5Right = new TreeNode(2);
        TreeNode root4 = new TreeNode(5);
        TreeNode left4 = new TreeNode(4);
        TreeNode right4 = new TreeNode(6);
        TreeNode right4Right = new TreeNode(3);
        root5.left = left5;
        root5.right = root4;
        left5.left = left5left;
        left5.right = left5Right;
        root4.left = left4;
        root4.right = right4;
        right4.right = right4Right;
        System.out.println(isValidBST(root4));
    }

    /**
     *     6             5
     *    / \           / \
     *   5   8         1  17
     *  / \              / \
     * 4  7            13  19
     *                / \
     *               4  18
     */
    public static boolean isValidBST(TreeNode root){
        boolean leftResult = true;
        boolean rightResult = true;
        if(root == null){
            return true;
        }
        if(root.left != null){
            if(root.left.val >= root.val){
                return false;
            }
            TreeNode left = root.left;
            if(left.left != null) {
                if (left.left.val >= left.val || left.left.val >= root.val) {
                    return false;
                }
            }
            if(left.right != null){
                if(left.right.val <= left.val || left.right.val >= root.val){
                    return false;
                }
            }
            leftResult = isValidBST(root.left);
        }
        if(root.right != null){
            if(root.right.val <= root.val){
                return false;
            }
            TreeNode right = root.right;
            if(right.right != null){
                if(right.right.val <= root.val || right.right.val <= right.val){
                    return false;
                }
            }
            if(right.left != null){
                if(right.left.val >= right.val || right.left.val <= root.val){
                    return false;
                }
            }
            rightResult = isValidBST(root.right);
        }
        return leftResult && rightResult;
    }
}
