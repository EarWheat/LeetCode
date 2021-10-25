package leetcode.Tree.lowestCommonAncestor;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-27 10:21
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class lowestCommonAncestorAnswer {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    /**
     * 利用二叉搜索树的特点，如果p、q的值都小于root，说明p q 肯定在root的左子树中；如果p q都大于root，说明肯定在root的右子树中，如果一个在左一个在右 则说明此时的root记为对应的最近公共祖先 //python3
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val==root.val){
            return p;
        }
        if (q.val==root.val){
            return q;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right,p,q);
        }else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }
}
