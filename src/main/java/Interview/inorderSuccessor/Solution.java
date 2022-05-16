package Interview.inorderSuccessor;

import leetcode.Util.TreeNode;

import java.util.LinkedList;

/**
 * @Desc: https://leetcode.cn/problems/successor-lcci/
 * @Author: 泽露
 * @Date: 2022/5/16 5:01 PM
 * @Version: 1.initial version; 2022/5/16 5:01 PM
 */
public class Solution {
    //           5
    //         /   \
    //        3     6
    //       / \
    //      1   4
    //       \
    //        2
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> treeNodes = midOrder(root);
        for (int i = 0; i < treeNodes.size(); i++) {
            if(treeNodes.get(i) == p){
                if(i == treeNodes.size() - 1){
                    return null;
                }
                return treeNodes.get(i + 1);
            }
        }
        return null;
    }

    public LinkedList<TreeNode> midOrder(TreeNode root){
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if(root == null){
            return treeNodes;
        }
        if(root.left != null){
            treeNodes.addAll(midOrder(root.left));
        }
        treeNodes.add(root);
        if(root.right != null){
            treeNodes.addAll(midOrder(root.right));
        }
        return treeNodes;
    }
}
