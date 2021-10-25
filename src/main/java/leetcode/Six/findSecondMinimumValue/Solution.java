package leetcode.Six.findSecondMinimumValue;

import leetcode.Util.TreeNode;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/27 2:55 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    /**
     * [1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
     *                                1
     *                         /           \
     *                        1            3
     *                       /    \          / \
     *                      1     1          3 4
     *                     / \    /\        /\ /\
     *                    3  1   1 1      3 8 4 8
     *                   /\ /\  / \
     *                  3 3 1 6 2 1
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        return findMin(root, root.val);
    }

    public int findMin(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }
        if (root.val > val) {
            return root.val;
        }
        int l = findMin(root.left, val);
        int r = findMin(root.right, val);
        if (l > val && r > val) {
            return Math.min(l,r);
        }
        return Math.max(l,r);
    }
}
