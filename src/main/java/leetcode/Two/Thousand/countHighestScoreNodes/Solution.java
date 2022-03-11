package leetcode.Two.Thousand.countHighestScoreNodes;

import java.util.*;

/**
 * @author ：liuzhaolu
 * @description：2049. 统计最高分的节点数目
 * @prd : https://leetcode-cn.com/problems/count-nodes-with-the-highest-score/
 * @date ：2022/3/11 2:24 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/11 2:24 下午     liuzhaolu       firstVersion
 */
public class Solution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int leftScore;
        int rightScore;
        int parentScore;
        int score;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public Set<TreeNode> nodes = new HashSet<>();
    int size = 0;

    public int countHighestScoreNodes(int[] parents) {
        size = parents.length;
        buildTree(parents);
        for(TreeNode node : nodes){
            treeScore(node);
        }
        TreeMap<Integer, Integer> res = new TreeMap<>();
        for(TreeNode node : nodes){
            if(node.leftScore == 0){
                node.leftScore = 1;
            }
            if(node.rightScore == 0){
                node.rightScore = 1;
            }
            if(node.parentScore == 0){
                node.parentScore = 1;
            }
            node.score = node.leftScore * node.rightScore * node.parentScore;
            res.put(node.score, res.getOrDefault(node.score, 0) + 1);
        }
        return res.get(res.lastKey());
    }

    public TreeNode buildTree(int[] parents) {
        TreeNode root = new TreeNode(0);
        nodes.add(root);
        for (int i = 1; i < parents.length; i++) {
            TreeNode node = getNodeByVal(i);
            TreeNode parent = getNodeByVal(parents[i]);
            node.parent = parent;
            if(parent.left == null){
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
        return root;
    }

    public TreeNode getNodeByVal(int val){
        for(TreeNode node : nodes){
            if(node.val == val){
                return node;
            }
        }
        TreeNode node = new TreeNode(val);
        nodes.add(node);
        return node;
    }


    public int treeScore(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            root.parentScore = size - 1;
            return 1;
        }
        root.leftScore = treeScore(root.left);
        root.rightScore = treeScore(root.right);
        root.parentScore = size - 1 - root.leftScore - root.rightScore;
        return root.leftScore + root.rightScore + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countHighestScoreNodes(new int[]{-1,2,0,2,0}));
    }
}
