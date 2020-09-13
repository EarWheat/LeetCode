package leetcode.Tree.inorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-14 07:54
 * @desc 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class inorderTraversal {
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(root.left != null){
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if(root.right != null){
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}
