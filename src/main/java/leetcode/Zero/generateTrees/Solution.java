package leetcode.Zero.generateTrees;

import leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：95. 不同的二叉搜索树 II
 * @prd : https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * @date ：2022/2/22 2:41 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/22 2:41 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return buildTrees(1, n);
    }

    public List<TreeNode> buildTrees(int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            List<TreeNode> result = new ArrayList<>();
            TreeNode temp = new TreeNode(start);
            result.add(temp);
            return result;
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftChilds = buildTrees(start, i - 1);
            List<TreeNode> rightChilds = buildTrees(i + 1, end);
            if (leftChilds != null && rightChilds != null) {
                for (TreeNode left : leftChilds) {
                    for (TreeNode right : rightChilds) {
                        TreeNode temp = new TreeNode(i);
                        temp.left = left;
                        temp.right = right;
                        result.add(temp);
                    }
                }
            } else if (leftChilds == null && rightChilds != null) {
                for (TreeNode right : rightChilds) {
                    TreeNode temp = new TreeNode(i);
                    temp.right = right;
                    result.add(temp);
                }
            } else if (rightChilds == null && leftChilds != null) {
                for (TreeNode left : leftChilds) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = left;
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> result = solution.generateTrees(3);
        System.out.println(result);
        System.out.println();
    }
}
