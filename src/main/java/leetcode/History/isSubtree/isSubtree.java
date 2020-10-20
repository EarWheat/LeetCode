package leetcode.History.isSubtree;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-07 10:41
 * @desc:给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
 * 前序：34125
 * 后序：12453
给定的树 t：

   4
  / \
 1   2
 * 前序：412
 * 后序：124
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
      \
       0
 341205
 * 后序：102453
给定的树 t：

   4
  / \
 1   2
 * 412
 * 后序：124
返回 false。

* 思路，中序遍历，包含子串则符合要求
 */
public class isSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(5);
        TreeNode leftL = new TreeNode(1);
        TreeNode leftR = new TreeNode(2);
        TreeNode leftRL = new TreeNode(0);
        root.left = left;
        root.right = right;
        left.left = leftL;
        left.right = leftR;
        leftR.right = leftRL;
        System.out.println(houXu(root));
        TreeNode t = new TreeNode(4);
        TreeNode tl = new TreeNode(1);
        TreeNode tr = new TreeNode(2);
        t.left = tl;
        t.right = tr;
        System.out.println(houXu(t));
        System.out.println(isSubtree(root,t));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
//t是s的子树，要么t等于s，要么t等于s的左/右子树。
        return subFrom(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static boolean subFrom(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return subFrom(s.left, t.left) && subFrom(s.right, t.right);
    }

    // 中序遍历
    public static String zhongXu(TreeNode root){
        String result = "";
        if(root.left != null){
            result += zhongXu(root.left);
        }
        result += root.val;
        if(root.right != null){
            result += zhongXu(root.right);
        }
        return result;
    }

    // 后序遍历
    public static String houXu(TreeNode root){
        String result = "";
        if(root.left != null){
            result += houXu(root.left);
        }        if(root.right != null){
            result += houXu(root.right);
        }
        result += root.val;
        return result;
    }
}
