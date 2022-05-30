package leetcode.One.Thousand.sumRootToLeaf;


import leetcode.Util.TreeNode;

import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/30 5:14 PM
 * @Version: 1.initial version; 2022/5/30 5:14 PM
 */
public class Solution {
    //            1
    //          /  \
    //         0     1
    //          \   / \
    //           1  1   0
    public int sumRootToLeaf(TreeNode root) {
        int result = 0;
        List<String> list = subTree(root);
        for(String s : list){
            result += parseList(s);
        }
        return result;
    }

    public List<String> subTree(TreeNode root){
        List<String> result = new ArrayList<>();
        if(root.left != null){
            List<String> temp = subTree(root.left);
            for(String t : temp){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(root.val).append(t);
                result.add(stringBuilder.toString());
            }
        }
        if(root.right != null){
            List<String> temp = subTree(root.right);
            for(String t : temp){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(root.val).append(t);
                result.add(stringBuilder.toString());
            }
        }
        if(root.left == null && root.right == null){
            return Arrays.asList(String.valueOf(root.val));
        }
        return result;
    }

    public Integer parseList(String s){
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(s.length() - 1 - i) == '1'){
                result += Math.pow(2, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Solution solution = new Solution();
        System.out.println(solution.sumRootToLeaf(node1));
    }
}
