package leetcode.Six.findTarget;

import leetcode.Util.TreeNode;

/**
 * @author ：liuzhaolu
 * @description：653. 两数之和 IV - 输入 BST
 * @prd : https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * @date ：2022/3/21 2:54 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/21 2:54 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        TreeNode small = null;
        TreeNode big = null;
        if(root.val >= k / 2){
            big = root;
            small = root.left;
        } else {
            big = root.right;
            small = root;
        }
        while (small != null && big != null){
            if(small.val + big.val == k){
                return true;
            } else if(small.val + big.val > k){
                // small变小或者big变小；
                if(big.left == null){
                    small = small.left;
                } else if(small.left == null){
                    big = big.left;
                } else {
                    if(big.left != small && small.val - small.left.val < big.val - big.left.val){
                        small = small.left;
                    } else {
                        if(big.left != small){
                            big = big.left;
                        } else {
                            small = small.left;
                        }
                    }
                }
            } else if(small.val + big.val < k){
                // small变大或者big变大
                if(big.right == null){
                    small = small.right;
                } else if(small.right == null){
                    big = big.right;
                } else {
                    if(small.right != big && small.val - small.right.val < big.val - big.right.val){
                        small = small.right;
                    } else {
                        big = big.right;
                    }
                }
            }
        }
        return false;
    }

}
