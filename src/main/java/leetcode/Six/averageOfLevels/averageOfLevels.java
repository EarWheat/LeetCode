package leetcode.Six.averageOfLevels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-12 07:34
 * @desc
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。

 * @prd Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class averageOfLevels {
    public static class TreeNode { int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<TreeNode> currentLevelNodes = new ArrayList<>();  // 当层节点数
        currentLevelNodes.add(root);
        while (currentLevelNodes.size() != 0){
            double levelSum = 0;   // 本层的和
            int num = currentLevelNodes.size(); // 本层节点数;
            List<TreeNode> nextLevelNodes = new ArrayList<>(); // 下一层节点数
            for(TreeNode node : currentLevelNodes){
                levelSum += node.val;
                if(node.left != null){
                    nextLevelNodes.add(node.left);
                }
                if(node.right != null){
                    nextLevelNodes.add(node.right);
                }
                currentLevelNodes = nextLevelNodes;
            }
            result.add(levelSum / num);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        List<Double> result = averageOfLevels(root);
        System.out.println(result.toString());
    }
}
