package leetcode.tree;
/*
 * @author:liuzhaolu
 * @createTime: 2019-09-01 16:10
 * @desc:求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 */

import java.util.ArrayList;

public class Solution {
    public int run(TreeNode root) {
        if(root == null){
            return 0;
        }
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        ArrayList<TreeNode> nodeTemp = new ArrayList<>();
        nodeList.add(root);
        int depth = 0;
        int flag = 0;
        while (flag != 1){
            depth++;
            for (int i = 0 ; i < nodeList.size(); i++){
                TreeNode node = nodeList.get(i);
                if(node.left == null && node.right == null){
                    flag = 1;
                    break;
                }
                if(node.left != null){
                    nodeTemp.add(node.left);
                }
                if(node.right != null){
                    nodeTemp.add(node.right);
                }
            }
            nodeList = nodeTemp;
            nodeTemp.clear();
        }
        return depth;
    }
}
