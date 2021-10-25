package leetcode.Eight.leafSimilar;

import leetcode.Util.TreeNode;
import leetcode.Util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/10 下午10:11
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = leaf(root1);
        List<Integer> leaf2 = leaf(root2);
        if(leaf1.size() != leaf2.size()){
            return false;
        }
        for (int i = 0; i < leaf1.size(); i++) {
            if(leaf1.get(i) != leaf2.get(i)){
                return false;
            }
        }
        return true;
    }

    public List<Integer> leaf(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if(root.left == null && root.right == null){
            result.add(root.val);
            return result;
        }
        if(root.left != null){
            result.addAll(leaf(root.left));
        }
        if(root.right != null){
            result.addAll(leaf(root.right)) ;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
