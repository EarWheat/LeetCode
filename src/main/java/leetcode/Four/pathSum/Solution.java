package leetcode.Four.pathSum;

import leetcode.Util.TreeNode;
import leetcode.Util.TreeNodeUtil;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/28 2:58 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int curPathNum = getCurPathNum(root, targetSum);
        return curPathNum + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int getCurPathNum(TreeNode root, int targetNum){
        if(root == null){
            return 0;
        }
        if(root.val == targetNum){
            return 1 + getCurPathNum(root.left, 0) + getCurPathNum(root.right, 0);
        }
        return getCurPathNum(root.left, targetNum - root.val) + getCurPathNum(root.right, targetNum - root.val);
    }




    public static void main(String[] args) {
//        TreeNode root = new TreeNode(-2);
//        root.right = new TreeNode(-3);
        Solution solution = new Solution();
        int[] nodes = new int[]{1,-2,-3,1,3,-2,Integer.MIN_VALUE,-1};
        TreeNode root = TreeNodeUtil.array2TreeNode(nodes);
        System.out.println(solution.pathSum(root,1));
    }

}
